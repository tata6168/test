package com.test.project.mapper;

import com.test.project.ProjectStart;
import com.test.project.entity.Permission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = ProjectStart.class)
@RunWith(SpringRunner.class)
public class PermissionMapperTest {
    @Autowired
    PermissionMapper permissionMapper;

    @Test
    public void searchTest(){
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        List<Permission> list = permissionMapper.batchSearch(ids);
        list.forEach(e->
                System.out.println(e));
    }
    @Test
    public void connectionTest(){

    }

}