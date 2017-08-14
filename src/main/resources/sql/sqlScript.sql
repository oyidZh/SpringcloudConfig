/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : activiti

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-08-06 20:54:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE IF NOT EXISTS `JUDGE_USER`(
  `user_id` varchar(20) NOT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `email_address` varchar(30) DEFAULT NULL,
  `ability_level` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for scheduleTime
-- ----------------------------
CREATE TABLE IF NOT EXISTS `JUDGE_SCHEDULE_TIME`(
  `course_name` varchar(50) DEFAULT NULL,
  `course_code` varchar(20) NOT NULL,
  `start_time` DATETIME DEFAULT NULL,
  `commit_end_time` DATETIME DEFAULT NULL,
  `judge_start_time` DATETIME DEFAULT NULL,
  `judge_end_time` DATETIME DEFAULT NULL,
  `audit_start_time` DATETIME DEFAULT NULL,
  `audit_end_time` DATETIME DEFAULT NULL,
  `publish_time` DATETIME DEFAULT NULL,
  PRIMARY KEY (`course_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
