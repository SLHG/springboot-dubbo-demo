package com.demo.service.impl;

import com.demo.beans.User;
import com.demo.dao.UserMapper;
import com.demo.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

@Service(group = "demo")
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userDao;

    @Override
    public User getUser(Integer id) {
        LOGGER.info("controller查询数据" + id);
        return userDao.getUser(id);
    }
}
