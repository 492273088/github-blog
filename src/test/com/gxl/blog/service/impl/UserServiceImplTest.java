package com.gxl.blog.service.impl;

import com.gxl.blog.mapper.UserMapper;
import com.gxl.blog.pojo.User;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Random;

/**
 * Created by XiaoLei Guo on 2017/6/8.
 */
public class UserServiceImplTest extends TestCase {
    ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:mybatis/spring-mybatis.xml");
    UserMapper userMapper = (UserMapper) ac.getBean("userMapper");


    public void testFindUserList() throws Exception {
        List<User> list = userMapper.findUserList();
        for (User user : list){
            System.out.println("userId:"+user.getId()+",userName:"+user.getUserName());
        }

    }

    public void testGetUserById() throws Exception {
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println("userId:"+user.getId()+",userName:"+user.getUserName());
    }

    public void testDeleteById() throws Exception {
        userMapper.deleteByPrimaryKey(1);
    }

    public void testUpdateByUser() throws Exception {
       User user = userMapper.selectByPrimaryKey(2);
        user.setUserName("张三");
        user.setAge(100);
       userMapper.updateByPrimaryKey(user);
    }

    public void testInsertUser() throws Exception {
        Random random = new Random();
        for(int i = 0;i<1000;i++){
            User user = new User();
            user.setAge(random.nextInt(100));
            user.setUserName("username"+random.nextInt(100));
            user.setPassword("password"+random.nextInt(100));
            userMapper.insert(user);

        }
    }

}