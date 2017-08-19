/*
Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : activiti

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE IF NOT EXISTS JUDGE_USER (
  USER_ID       INT(11)     NOT NULL AUTO_INCREMENT,
  USER_NAME     VARCHAR(20)          DEFAULT NULL,
  EMAIL_ADDRESS VARCHAR(30) NOT NULL,
  ABILITY_LEVEL VARCHAR(10)          DEFAULT NULL,
  UNIQUE INDEX index_email_address (EMAIL_ADDRESS),
  PRIMARY KEY (USER_ID)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for scheduleTime
-- ----------------------------
CREATE TABLE IF NOT EXISTS JUDGE_SCHEDULE_TIME (
  COURSE_NAME      VARCHAR(50) NOT NULL,
  COURSE_CODE      VARCHAR(20) NOT NULL,
  START_TIME       DATETIME    NOT NULL,
  COMMIT_END_TIME  DATETIME    NOT NULL,
  JUDGE_START_TIME DATETIME    NOT NULL,
  JUDGE_END_TIME   DATETIME    NOT NULL,
  AUDIT_START_TIME DATETIME    NOT NULL,
  AUDIT_END_TIME   DATETIME    NOT NULL,
  PUBLISH_TIME     DATETIME    NOT NULL,
  judgeTimes       INT DEFAULT 3,
  UNIQUE INDEX index_COURSE_CODE (COURSE_CODE),
  PRIMARY KEY (COURSE_CODE)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
