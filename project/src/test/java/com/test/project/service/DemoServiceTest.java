package com.test.project.service;

import com.test.project.ProjectStart;
import com.test.project.entity.Demo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.crypto.Data;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = ProjectStart.class)
@RunWith(SpringRunner.class)
class DemoServiceTest {
    @Autowired
    DemoService demoService;
    @Test
    void insert() {
        Demo demo = new Demo();
        demo.setId(1l);
        demo.setCity("成都");
        demo.setName("长江");
        demo.setDate(new Date());
        demoService.insert(demo);
    }

    @Test
    void update() {
    }

    @Test
    void searchList() {
        demoService.update(null);
    }

    @Test
    void delete() {
    }
}