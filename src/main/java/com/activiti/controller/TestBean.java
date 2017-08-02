package com.activiti.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 12490 on 2017/8/1.
 */
public class TestBean {
    private final Logger logger = LoggerFactory.getLogger(TestBean.class);

    TestBean(String test) {
        logger.info("测试xml配置bean==========" + test);
    }
}
