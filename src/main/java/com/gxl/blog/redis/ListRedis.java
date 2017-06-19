package com.gxl.blog.redis;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisListCommands;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by XiaoLei Guo on 2017/6/15.
 */
@Component("listRedis")
public class ListRedis {

    @Resource
    private StringRedisTemplate redisTemplate;

    public String index(final String key, final long index) {
        return redisTemplate.opsForList().index(key,index);
    }

    public String leftPop(final String key) {
        return redisTemplate.opsForList().leftPop(key);
    }

    public String leftPop(final String key, long timeout, TimeUnit unit) {
        return redisTemplate.opsForList().leftPop(key,timeout,unit);
    }

    public Long leftPush(String key, String value) {
        return redisTemplate.opsForList().leftPush(key,value);
    }

    public Long leftPushAll(String key, String... values) {
        return redisTemplate.opsForList().leftPushAll(key,values);
    }

    public Long leftPushIfPresent(String key, String value) {
        return redisTemplate.opsForList().leftPushIfPresent(key,value);
    }

    public Long leftPush(String key, String pivot, String value) {
        return redisTemplate.opsForList().leftPush(key,pivot,value);
    }

    public Long size(String key) {
        return redisTemplate.opsForList().size(key);
    }

    public List<String> range(String key, final long start, final long end) {
        return redisTemplate.opsForList().range(key,start,end);
    }

    public Long remove(String key, final long count, String value) {
        return redisTemplate.opsForList().remove(key,count,value);
    }

    public String rightPop(final String key) {
        return redisTemplate.opsForList().rightPop(key);
    }

    public String rightPop(final String key, long timeout, TimeUnit unit) {
        return redisTemplate.opsForList().rightPop(key,timeout,unit);
    }

    public Long rightPush(String key, String value) {
        return redisTemplate.opsForList().rightPush(key,value);
    }

    public Long rightPushAll(String key, String... values) {
        return redisTemplate.opsForList().leftPushAll(key,values);
    }

    public Long rightPushIfPresent(String key, String value) {
        return redisTemplate.opsForList().rightPushIfPresent(key,value);
    }

    public Long rightPush(String key, String pivot, String value) {
        return redisTemplate.opsForList().rightPush(key,pivot,value);
    }

    public String rightPopAndLeftPush(final String sourceKey, String destinationKey) {
        return redisTemplate.opsForList().rightPopAndLeftPush(sourceKey,destinationKey);
    }

    public String rightPopAndLeftPush(final String sourceKey, String destinationKey, long timeout, TimeUnit unit) {
        return redisTemplate.opsForList().rightPopAndLeftPush(sourceKey,destinationKey,timeout,unit);
    }

    public void set(final String key, final long index, String value) {
        redisTemplate.opsForList().set(key,index,value);
    }

    public void trim(final String key, final long start, final long end) {
        redisTemplate.opsForList().trim(key,start,end);
    }

}
