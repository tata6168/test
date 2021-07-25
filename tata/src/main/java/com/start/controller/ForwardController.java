package com.start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("forward")
public class ForwardController {
    @RequestMapping("main")
    public String main(){
        return "main";
    }
    @RequestMapping("table/permission")
    public String permissionTable(){
        return "table/permission";
    }
    @RequestMapping("table/role")
    public String roleTable(){
        return "table/role";
    }
    @RequestMapping("table/user")
    public String userTable(){
        return "table/user";
    }
    @RequestMapping("edit/page")
    public String pageEdit(){
        return "page/menuEdit";
    }
}
