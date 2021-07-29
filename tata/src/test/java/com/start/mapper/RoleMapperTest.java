package com.start.mapper;


import com.start.LiuyanStart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = LiuyanStart.class)
@RunWith(SpringRunner.class)
public class RoleMapperTest {
@Autowired
RoleMapper roleMapper;
    @Test
    public void shiroInit() {
        roleMapper.roleIdGetSn(1);
    }
}