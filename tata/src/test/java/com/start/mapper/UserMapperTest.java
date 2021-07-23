package com.start.mapper;

import com.start.LiuyanStart;
import com.start.entity.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = LiuyanStart.class)
@RunWith(SpringRunner.class)
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;
    @Test
    public void userGetMenu(){
        List<Integer> integers = Arrays.asList(1, 2, 3);
        List<Menu> menu = userMapper.getMenu(integers);
        System.out.println(menu.size());
    }
}