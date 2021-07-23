package com.test.mapper;

import com.test.demo.User;

public interface UserMapper extends BaseMapper<User> {
    void autoIncrement();
    void selectPage();
}
