package distributed.transaction.mappers;


import distributed.transaction.model.EventPublish;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Dean
 */
public interface EventPublishMapper {

	Integer save(EventPublish eventPublish);

	List<EventPublish> list(Map<String, Object> param);

	Integer updateStatus(@Param("ids") List<Long> ids, @Param("status") String status);
}
