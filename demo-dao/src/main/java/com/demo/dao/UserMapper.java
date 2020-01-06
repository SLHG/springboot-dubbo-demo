package com.demo.dao;

import com.demo.beans.User;

import java.util.List;

public interface UserMapper {
    User getUser(Integer id);

    List<User> getUserByName(String name);
}
