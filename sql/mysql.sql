/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3307
 Source Schema         : kafka

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 28/09/2019 13:46:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for saas_house
-- ----------------------------
DROP TABLE IF EXISTS `saas_house`;
CREATE TABLE `saas_house`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` int(255) DEFAULT NULL COMMENT '库存数量',
  `commodity_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品代码',
  `commodity_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '仓库' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_kafka_event_process
-- ----------------------------
DROP TABLE IF EXISTS `t_kafka_event_process`;
CREATE TABLE `t_kafka_event_process`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `payload` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `eventType` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
