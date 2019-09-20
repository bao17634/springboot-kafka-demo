package distributed.transaction.utils;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.CommitFailedException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Properties;
import java.util.function.Consumer;

/**
 * @ClassName: KafkaUtils
 * @Description: kafka 配置
 * @Author: yanrong
 * @Date: 2019/9/20 15:59
 * @Version: 1.0
 */
@Component
@Slf4j
public class KafkaUtils {
	private static KafkaConsumer<String, String> consumer;

	static {
		//消费者配置
		Properties consumerProps = new Properties();
		consumerProps.put("bootstrap.servers", "localhost:9092");
		consumerProps.put("key.deserializer",
				"org.apache.kafka.common.serialization.StringDeserializer");
		consumerProps.put("value.deserializer",
				"org.apache.kafka.common.serialization.StringDeserializer");
		consumerProps.put("group.id", "VoucherGroup");
		//关闭自动提交offset
		consumerProps.put("enable.auto.commit", "false");
		consumer = new KafkaConsumer<>(consumerProps);
	}
	/**
	 * 消费消息
	 *
	 * @param c 回调函数，处理消息
	 */
	public static void consume(Consumer<ConsumerRecord<String, String>> c) {
		consumer.subscribe(Lists.newArrayList(EventType.USER_CREATED.name()));
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(100);
			for (ConsumerRecord<String, String> record : records) {
				log.debug("接收到消息，ConsumerRecord={}", record);
				c.accept(record);
			}
			try {
				//同步手动提交offset
				consumer.commitSync();
			} catch (CommitFailedException e) {
				log.error("Kafka消费者提交offset失败", e);
			}
		}
	}

}
