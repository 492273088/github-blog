package com.gxl.blog.redis;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by XiaoLei Guo on 2017/6/15.
 */
@Component("hashRedis")
public class HashRedis {

    @Resource
    private StringRedisTemplate redisTemplate;


    public Object get(String key, Object hashKey) {
        return redisTemplate.opsForHash().get(key,hashKey);
    }

    public Boolean hasKey(String key, Object hashKey) {
        return redisTemplate.opsForHash().hasKey(key,hashKey);
    }

    public Long increment(String key, String hashKey, final long delta) {
        return redisTemplate.opsForHash().increment(key,hashKey,delta);
    }

    public Double increment(String key, String hashKey, final double delta) {
        return redisTemplate.opsForHash().increment(key,hashKey,delta);
    }

    public Set<Object> keys(String key) {
        return redisTemplate.opsForHash().keys(key);
    }

    public Long size(String key) {
        return redisTemplate.opsForHash().size(key);
    }

    public void putAll(String key, Map<Object, Object> map) {
        redisTemplate.opsForHash().putAll(key,map);
    }

    public List<Object> multiGet(String key, Collection<Object> fields) {
        return redisTemplate.opsForHash().multiGet(key,fields);
    }

    public void put(String key, Object hashKey, Object value) {
        redisTemplate.opsForHash().put(key,hashKey,value);
    }

    public Boolean putIfAbsent(String key, Object hashKey, Object value) {
        return redisTemplate.opsForHash().putIfAbsent(key,hashKey,value);
    }

    public List<Object> values(String key) {
        return redisTemplate.opsForHash().values(key);
    }

    public void delete(String key, Object... hashKeys) {
        redisTemplate.opsForHash().delete(key,hashKeys);
    }

    public Map<Object, Object> entries(String key) {
        return redisTemplate.opsForHash().entries(key);
    }
}
