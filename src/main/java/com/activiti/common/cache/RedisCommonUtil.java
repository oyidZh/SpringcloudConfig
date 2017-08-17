package com.activiti.common.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Component;

import java.io.NotSerializableException;

import static com.mchange.v2.ser.SerializableUtils.toByteArray;
import static jdk.nashorn.internal.runtime.JSType.toObject;

/**
 * Created by 12490 on 2017/8/17.
 */
@Component
public class RedisCommonUtil {
    private static final Logger logger = LoggerFactory.getLogger(EhRedisCache.class);

    @Autowired
    public RedisTemplate<String, String> redisTemplate;

    /**
     * 根据key从redis里面取数据
     *
     * @param key
     * @return
     */
    public Object get(final String key) {
        Object objectValue= redisTemplate.execute(new RedisCallback<Object>() {
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {
                byte[] byteKey = key.getBytes();
                byte[] value = connection.get(byteKey);
                if (value == null) {
                    return null;
                }
                return toObject(value);
            }
        }, true);
        logger.info("Cache L2 get (redis) :{}={}", key, objectValue);
        return objectValue;
    }

    /**
     * 向redis里面存数据
     * @param key
     * @param valueStr
     * @param liveTime
     */
    public void put(final String key,final Object valueStr, long liveTime) {
        redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                byte[] keyb = key.getBytes();
                byte[] valueb = new byte[0];
                try {
                    valueb = toByteArray(valueStr);
                } catch (NotSerializableException e) {
                    e.printStackTrace();
                }
                connection.set(keyb, valueb, Expiration.seconds(liveTime), RedisStringCommands.SetOption.UPSERT);
                logger.info("Cache L2 put (redis) :{}={}", key, valueb);
                if (liveTime > 0) {
                    connection.expire(keyb, liveTime);
                }
                return 1L;
            }
        }, true);
    }

    /**
     * 刪除所有redis緩存
     */
    public void deleteAll(){
        redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.flushDb();
                return "clear done.";
            }
        }, true);
    }

    /**
     * 刪除指定key
     * @param key
     */
    public void deleteOne(String key){
        redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.del(key.getBytes());
            }
        }, true);
    }
}
