/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : jwc_score_job

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 03/04/2019 18:32:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `uid` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '学号',
  `address` varchar(64) NOT NULL DEFAULT '' COMMENT '地址',
  `email` varchar(64) NOT NULL DEFAULT '' COMMENT '邮箱',
  `company` varchar(64) NOT NULL DEFAULT '' COMMENT '企业',
  `job_name` varchar(64) NOT NULL DEFAULT '' COMMENT '岗位',
  `organizer` varchar(64) NOT NULL DEFAULT '' COMMENT '举办单位',
  `action_time` bigint(22) NOT NULL DEFAULT '0' COMMENT '举办时间（毫秒）',
  `extra` text COMMENT '描述',
  `record_status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否有效 0:正常 1:失效',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='就业表';

-- ----------------------------
-- Table structure for total_score
-- ----------------------------
DROP TABLE IF EXISTS `total_score`;
CREATE TABLE `total_score` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `uid` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '学号',
  `calss_num` varchar(10) NOT NULL DEFAULT '' COMMENT '课程号',
  `class_name` varchar(256) NOT NULL DEFAULT '' COMMENT '课程名',
  `no_id` int(5) NOT NULL DEFAULT '0' COMMENT '序号',
  `credit` double NOT NULL DEFAULT '0' COMMENT '学分',
  `time` varchar(16) NOT NULL DEFAULT '' COMMENT '学期',
  `grade` double NOT NULL DEFAULT '0' COMMENT '得分',
  `record_status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否有效 0:正常 1:失效',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `term` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成绩表';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `uid` varchar(11) NOT NULL DEFAULT '' COMMENT '学号',
  `username` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '姓名',
  `password` varchar(256) NOT NULL DEFAULT '' COMMENT '密码（加密）',
  `college` varchar(256) NOT NULL DEFAULT '' COMMENT '学院',
  `major` varchar(256) NOT NULL DEFAULT '' COMMENT '专业',
  `user_type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '用户类型 0:学生 1:教师 2:企业',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `record_status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '0:可用 1:错误',
  PRIMARY KEY (`id`,`uid`) USING BTREE,
  UNIQUE KEY `uniq_idx_metric` (`uid`,`username`) USING BTREE,
  KEY `uid` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';

SET FOREIGN_KEY_CHECKS = 1;
