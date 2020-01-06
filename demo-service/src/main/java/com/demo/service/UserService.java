package com.demo.service;

import com.demo.beans.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    User getUser(Integer id);

    PageInfo<User> getUserByName(String name);
}
