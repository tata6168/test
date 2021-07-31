package com.start.mapper;

import com.start.LiuyanStart;
import com.start.entity.Menu;
import com.start.entity.Query;
import com.start.service.ShiroService;
import com.start.service.UnifyService;
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
    @Autowired
    UnifyService unifyService;
    @Autowired
    ShiroService shiroService;
    @Test
    public void userGetMenu(){
        System.out.println(userMapper.getLogInfoById("1").getPasswords());
        List<Integer> integers = Arrays.asList(1, 2, 3);
        List<Menu> menu = userMapper.getMenu(integers);
        System.out.println(menu.size());
    }
    @Test
    public void mybatisCache(){
        Query query = new Query();
        query.setLimit(10);
        query.setStart(1l);
        userMapper.searchAllUser(query);
        query = new Query();
        query.setLimit(10);
        query.setStart(1l);
        userMapper.searchAllUser(query);
    }
    @Test
    public void springCache(){
        System.out.println(unifyService.count("t_role"));
        //shiroService.deleteRole(2);
        System.out.println(unifyService.count("t_role"));

    }
}