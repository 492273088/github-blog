package com.gxl.blog.service;

import com.gxl.blog.pojo.User;

import java.util.List;

/**
 * Created by XiaoLei Guo on 2017/6/8.
 */
public interface IUserService {

    List<User> findUserList();

    User getUserById(Integer Id);

    Boolean deleteById(Integer Id);

    Boolean updateByUser(User user);

    Boolean insertUser(User user);

    Boolean exists(User user);

    void batchInsert(List<User> list);

    void batchDelete(List<Integer> ids);
}
