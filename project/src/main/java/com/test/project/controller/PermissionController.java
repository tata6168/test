package com.test.project.controller;

import com.test.project.entity.Permission;
import com.test.project.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    PermissionService permissionService;
    @RequestMapping("/allInfo")
    @ResponseBody
    public List<Permission> simpleAllInfo(boolean sign){
        return permissionService.searchAll(false);
    }


}
