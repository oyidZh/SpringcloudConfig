package com.activiti.common.cache;

/**
 * Created by 12490 on 2017/8/17.
 */
public class KeyWrapper {
    private String ehcacheName;
    private long redisExpireTime;
    private String realKey;
    private boolean isValid;

    public KeyWrapper() {
    }

    public KeyWrapper(boolean isValid) {
        this.isValid = isValid;
    }

    public KeyWrapper(String ehcacheName, long redisExpireTime, String realKey) {
        this.ehcacheName = ehcacheName;
        this.redisExpireTime = redisExpireTime;
        this.realKey = realKey;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getEhcacheName() {
        return ehcacheName;
    }

    public void setEhcacheName(String ehcacheName) {
        this.ehcacheName = ehcacheName;
    }

    public long getRedisExpireTime() {
        return redisExpireTime;
    }

    public void setRedisExpireTime(long redisExpireTime) {
        this.redisExpireTime = redisExpireTime;
    }

    public String getRealKey() {
        return realKey;
    }

    public void setRealKey(String realKey) {
        this.realKey = realKey;
    }

    @Override
    public String toString() {
        return "KeyWrapper{" +
                "ehcacheName='" + ehcacheName + '\'' +
                ", redisExpireTime=" + redisExpireTime +
                ", realKey='" + realKey + '\'' +
                ", isValid=" + isValid +
                '}';
    }
}
