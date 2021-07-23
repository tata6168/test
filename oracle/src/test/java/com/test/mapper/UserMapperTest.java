package com.test.mapper;

import com.test.OracleServerStart;
import com.test.demo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {OracleServerStart.class})
@RunWith(SpringRunner.class)
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;
    @Test
    public void insert(){
        userMapper.autoIncrement();
    }
}