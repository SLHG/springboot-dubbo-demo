package com.demo.service.impl;

import com.demo.beans.User;
import com.demo.dao.UserMapper;
import com.demo.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service(group = "demo")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userDao;

    @Override
    public User getUser(Integer id) {
        return userDao.getUser(id);
    }
}
