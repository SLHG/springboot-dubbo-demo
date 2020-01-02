package com.demo.service.impl;

import com.demo.beans.User;
import com.demo.service.BaseUnitTest;
import com.demo.service.UserService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class UserServiceImplTest extends BaseUnitTest {

    @Autowired
    UserService userService;

    private static final Logger LOGGER = Logger.getLogger(UserServiceImplTest.class);

    @Test
    void getUserTest() {
        User user = userService.getUser(1);
        Assertions.assertNotNull(user);
        LOGGER.info("单元测试" + user);
    }

}
