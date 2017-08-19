/*
Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : activiti

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE IF NOT EXISTS `JUDGE_USER`(
  `USER_ID` varchar(20) NOT NULL,
  `USER_NAME` varchar(20) DEFAULT NULL,
  `EMAIL_ADDRESS` varchar(30) NOT NULL,
  `ABILITY_LEVEL` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for scheduleTime
-- ----------------------------
CREATE TABLE IF NOT EXISTS `JUDGE_SCHEDULE_TIME`(
  `COURSE_NAME` varchar(50) NOT NULL,
  `COURSE_CODE` varchar(20) NOT NULL,
  `START_TIME` DATETIME NOT NULL,
  `COMMIT_END_TIME` DATETIME NOT NULL,
  `JUDGE_START_TIME` DATETIME NOT NULL,
  `JUDGE_END_TIME` DATETIME NOT NULL,
  `AUDIT_START_TIME` DATETIME NOT NULL,
  `AUDIT_END_TIME` DATETIME NOT NULL,
  `PUBLISH_TIME` DATETIME NOT NULL,
  PRIMARY KEY (`COURSE_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
