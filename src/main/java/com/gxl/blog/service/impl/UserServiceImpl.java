package com.gxl.blog.service.impl;

import com.gxl.blog.mapper.UserMapper;
import com.gxl.blog.pojo.User;
import com.gxl.blog.redis.HashRedis;
import com.gxl.blog.redis.RedisCache;
import com.gxl.blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by XiaoLei Guo on 2017/6/8.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private HashRedis hashRedis;

    public List<User> findUserList() {
        Long time = System.currentTimeMillis();
        List<User> list = userMapper.findUserList();
        Long count = hashRedis.size("user");
        for (User user : list){
            hashRedis.put("user",user.getId().toString(),user.getUserName());
        }
        return userMapper.findUserList();
    }

    public User getUserById(Integer Id) {
        return userMapper.selectByPrimaryKey(Id);
    }

    public Boolean deleteById(Integer Id) {
        Integer state = userMapper.deleteByPrimaryKey(Id);
        if(state>0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean updateByUser(User user) {
        Integer state =  userMapper.updateByPrimaryKey(user);
        redisCache.hset("user",user.getId().toString(),user.getUserName());
        if(state>0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean insertUser(User user) {
        Integer state =  userMapper.insert(user);
        if(state>0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean exists(User user) {
        return redisCache.hexists(user.getId().toString(),user.getUserName());
    }
}
