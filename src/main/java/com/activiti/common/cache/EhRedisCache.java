package com.activiti.common.cache;

import net.sf.ehcache.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.NotSerializableException;
import java.util.concurrent.Callable;

import static com.mchange.v2.ser.SerializableUtils.toByteArray;
import static jdk.nashorn.internal.runtime.JSType.toObject;

/**
 * Created by 12490 on 2017/8/6.
 */
public class EhRedisCache implements Cache {

    private static final Logger logger = LoggerFactory.getLogger(EhRedisCache.class);

    private String name;

    private net.sf.ehcache.Cache ehCache;

    private RedisTemplate<String, String> redisTemplate;

    private long liveTime = 1*60*60; //默认1h=1*60*60
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Object getNativeCache() {
        return this;
    }

    @Override
    public ValueWrapper get(Object key) {
        Element value = ehCache.get(key);
        logger.info("Cache L1 get (ehcache) :{}={}",key,value);
        if (value!=null) {
            return (value != null ? new SimpleValueWrapper(value.getObjectValue()) : null);
        }
        final String keyStr = key.toString();
        Object objectValue = redisTemplate.execute(new RedisCallback<Object>() {
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {
                byte[] key = keyStr.getBytes();
                byte[] value = connection.get(key);
                if (value == null) {
                    return null;
                }
                //每次获得，重置缓存过期时间
                if (liveTime > 0) {
                    connection.expire(key, liveTime);
                }
                return toObject(value);
            }
        },true);
        ehCache.put(new Element(key, objectValue));//取出来之后缓存到本地
        logger.info("Cache L2 get (redis) :{}={}",key,objectValue);
        return  (objectValue != null ? new SimpleValueWrapper(objectValue) : null);
    }

    @Override
    public <T> T get(Object o, Class<T> aClass) {
        return null;
    }

    @Override
    public <T> T get(Object o, Callable<T> callable) {
        return null;
    }

    @Override
    public void put(Object key, Object value) {
        ehCache.put(new Element(key, value));
        final String keyStr =  key.toString();
        final Object valueStr = value;
        redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                byte[] keyb = keyStr.getBytes();
                byte[] valueb = new byte[0];
                try {
                    valueb = toByteArray(valueStr);
                } catch (NotSerializableException e) {
                    e.printStackTrace();
                }
                connection.set(keyb, valueb);
                logger.info("Cache L2 put (redis) :{}={}",key,valueb);
                if (liveTime > 0) {
                    connection.expire(keyb, liveTime);
                }
                return 1L;
            }
        },true);
    }

    @Override
    public ValueWrapper putIfAbsent(Object o, Object o1) {
        return null;
    }

    @Override
    public void evict(Object key) {
        ehCache.remove(key);
        final String keyStr =  key.toString();
        redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.del(keyStr.getBytes());
            }
        },true);
    }

    @Override
    public void clear() {
        ehCache.removeAll();
        redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.flushDb();
                return "clear done.";
            }
        },true);
    }

    public void setName(String name) {
        this.name = name;
    }

    public net.sf.ehcache.Cache getEhCache() {
        return ehCache;
    }

    public void setEhCache(net.sf.ehcache.Cache ehCache) {
        this.ehCache = ehCache;
    }

    public RedisTemplate<String, String> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public long getLiveTime() {
        return liveTime;
    }

    public void setLiveTime(long liveTime) {
        this.liveTime = liveTime;
    }
}
