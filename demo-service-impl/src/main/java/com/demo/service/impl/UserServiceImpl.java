package com.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.demo.beans.User;
import com.demo.dao.UserMapper;
import com.demo.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

@Service(group = "demo")
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userDao;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public User getUser(Integer id) {
        ValueOperations<String, Object> opsVal = redisTemplate.opsForValue();
        Object o = opsVal.get(String.valueOf(id));
        if (o != null) {
            return JSON.parseObject((String) o, User.class);
        }
        LOGGER.info("controller查询数据" + id);
        User user = userDao.getUser(id);
        if (user != null) {
            LOGGER.info("查询到的数据" + JSON.toJSONString(user));
            opsVal.set(String.valueOf(id), JSON.toJSONString(user), 600, TimeUnit.SECONDS);
        }
        return user;
    }
}
