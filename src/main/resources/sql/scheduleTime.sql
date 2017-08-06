-- ----------------------------
-- Table structure for scheduleTime
-- ----------------------------
CREATE TABLE IF NOT EXISTS `JUDGE_SCHEDULE_TIME`(
  `course_name` varchar(20) DEFAULT NULL,
  `course_code` varchar(20) NOT NULL,
  `start_time` DATETIME DEFAULT NULL,
  `commit_end_time` DATETIME DEFAULT NULL,
  `finish_time` DATETIME DEFAULT NULL,
  `publish_time` DATETIME DEFAULT NULL,
  PRIMARY KEY (`course_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;