package com.activiti.common.cache;

import com.alibaba.fastjson.JSONObject;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 12490 on 2017/8/16.
 */
@Aspect
@Component
public class CacheAspect implements ApplicationContextAware {
    private static final Logger logger = LoggerFactory.getLogger(CacheAspect.class);

    private static Map<String, Cache> cacheMap = new HashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Cache ehCache = (net.sf.ehcache.Cache) applicationContext.getBean("ehCacheRedisCache");
        CacheManager cacheManager = ehCache.getCacheManager();
        String[] cacheNames = cacheManager.getCacheNames();
        if (cacheNames != null && cacheNames.length > 0) {
            for (String cacheName : cacheNames) {
                logger.info("开始加载ehCache对象-->===========" + cacheName);
                cacheMap.put(cacheName, cacheManager.getCache(cacheName));
            }
        }
    }

    @Pointcut(value = "execution(@EhcacheRedisCache * *.*(..))")
    public void setCacheRedis(){}

    @Around("setCacheRedis()")
    public Object aroundExec(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Method method = ms.getMethod();
        EhcacheRedisCache ehcacheRedisCache=method.getAnnotation(EhcacheRedisCache.class);
        logger.info("================================"+ehcacheRedisCache.key());
        return joinPoint.proceed();
    }
}
