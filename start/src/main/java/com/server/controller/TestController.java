package com.server.controller;

import com.server.entity.User;
import com.server.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    TestService testService;
    @GetMapping("register")
    public void register(User user){
        testService.addUser(user);
    }
    @GetMapping("getData")
    public List<User> getAllData(){
        return testService.getAllData();
    }
    @GetMapping("updateUser")
    public void updateUser(User user){

        testService.updateUser(user);
    }
}
