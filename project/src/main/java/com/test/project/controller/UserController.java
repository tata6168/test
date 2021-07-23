package com.test.project.controller;

import com.test.project.entity.Menu;
import com.test.project.entity.RoleTransferInfo;
import com.test.project.entity.TransferUpdateInfo;
import com.test.project.entity.User;
import com.test.project.service.MenuService;
import com.test.project.service.RoleService;
import com.test.project.service.UserService;
import com.test.project.util.JsonResult;
import com.test.project.util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {
    List<Menu> cache;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;
    @PostMapping("/login")
    public void login(User user){
        userService.register(user);
    }
    @GetMapping("/register")
    public void register(User user){
        userService.register(user);
    }
    @GetMapping("table")
    public JsonResult userAllInfo(Query query){
        System.out.println(query.getPage()+"/"+query.getLimit());
        List<User> userList = userService.searchPage(query);
        return JsonResult.packaging(userList,userService.count(),"");
    }
    @PostMapping("/searchRole")
    public RoleTransferInfo userGetRole(Long userId){
        RoleTransferInfo info = new RoleTransferInfo();
        info.setRoleList(roleService.searchAll());
        info.setUserRoleIds(userService.searchRoleIds(userId));
        return info;
    }

    @GetMapping("/updateRole")
    public String updateRole(TransferUpdateInfo info){
        userService.updateRole(info);
        return "mm";
    }

    @GetMapping("/userGetMenu")
    public JsonResult userGetMenu(Long userId){
        return JsonResult.packaging(menuService.getUserMenu(userId),null,"success");
    }
    int count;
    @GetMapping("/roleBatchGetMenu")
    public JsonResult roleBatchGetMenu(){
        System.out.println(count++);
        if(cache==null)
            cache = menuService.getBatchRoleMenu(Arrays.asList(1));
        return JsonResult.packaging(cache,null,"");
    }

}
