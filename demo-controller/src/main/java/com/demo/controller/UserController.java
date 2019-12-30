package com.demo.controller;

import com.demo.beans.User;
import com.demo.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequestMapping("/user")
public class UserController {

    @Reference(group = "demo", url = "localhost:20880")
    private UserService userService;

    @RequestMapping("/getUser")
    public User getUser(Integer id) {
        return userService.getUser(id);
    }
}
