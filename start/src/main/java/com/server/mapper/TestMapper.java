package com.server.mapper;

import com.server.entity.User;

import java.util.List;

public interface TestMapper {
    void addUser(User user);

    List<User> getAllData();

    void updateUser(User user);

    void whiteList(Long id);

    void blackList(Long id);

    void deleteUser(Long id);
}
