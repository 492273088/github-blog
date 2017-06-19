package com.gxl.blog.controller;

import com.gxl.blog.pojo.User;
import com.gxl.blog.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by XiaoLei Guo on 2017/6/7.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private IUserService iUserService;
    //添加一个日志器
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    //映射一个action
    @RequestMapping("/index")
    public  String index(){
        List<User> list = iUserService.findUserList();
        //输出日志文件
        logger.info("the first jsp pages");
        //返回一个index.jsp这个视图
        return "index";
    }
}
