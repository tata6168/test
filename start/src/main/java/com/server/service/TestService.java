package com.server.service;

import com.server.entity.User;

import java.util.List;

public interface TestService {
    void addUser(User user);

    List<User> getAllData();

    void updateUser(User user);

    void deleteUser(Long id);

    void blacklist(Long id);

    void whiteList(Long id);
}
