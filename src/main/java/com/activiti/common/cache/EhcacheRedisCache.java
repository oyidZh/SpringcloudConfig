package com.activiti.common.cache;

import java.lang.annotation.*;

/**
 * Created by 12490 on 2017/8/16.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EhcacheRedisCache {
    String key();

    String cacheName();

    long redisExpire() default 3600;
}
