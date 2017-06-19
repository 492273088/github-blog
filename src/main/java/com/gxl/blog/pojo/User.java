package com.gxl.blog.pojo;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

//实体类别名，mapping.xml文件中省得写好长的包名
@Alias(value="user")
public class User implements Serializable{
    private Integer id;

    private String user_name;

    private String password;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return user_name;
    }

    public void setUserName(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}