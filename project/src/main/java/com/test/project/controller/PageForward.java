package com.test.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("page")
public class PageForward {
    @RequestMapping("user")
    public String page(){
        return "user";
    }
    @RequestMapping("role")
    public String  role(){
        return "role";
    }
    @RequestMapping("test")
    public String test(){
        return "test";
    }
    @RequestMapping("main")
    public String main(){return "main";}
}
