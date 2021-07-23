package com.test.project.controller;

import com.test.project.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/shiro")
@Controller
public class LoginAndOut {
    @RequestMapping("/login")
    @ResponseBody
    public String login(User user){

        return "main";
    }
}
