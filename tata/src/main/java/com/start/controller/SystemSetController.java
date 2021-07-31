package com.start.controller;

import com.start.cache.RoleSnCache;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sys")
public class SystemSetController {
    /*
    * 设置普通注册用户角色
    * */
    @GetMapping("set/noemalroleId")
    public void noemalRoleIdSetting(Integer normalRoleId){
        RoleSnCache.registerInitRoleId = normalRoleId;
    }
}
