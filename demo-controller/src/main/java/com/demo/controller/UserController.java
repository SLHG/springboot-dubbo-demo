package com.demo.controller;

import com.demo.beans.User;
import com.demo.service.UserService;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class);

    @Reference(group = "demo", url = "${control-dubbo.service.url}")
    private UserService userService;

    @GetMapping("/getUser")
    public User getUser(Integer id) {
        LOGGER.info("service查询信息" + id);
        return userService.getUser(id);
    }

    @GetMapping("/getUserByName")
    public PageInfo<User> getUserByName(String name) {
        LOGGER.info("service查询信息" + name);
        return userService.getUserByName(name);
    }
}
