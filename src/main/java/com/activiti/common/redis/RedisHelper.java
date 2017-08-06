package com.activiti.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by 12490 on 2017/8/6.
 */
@Component
public class RedisHelper {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
}
