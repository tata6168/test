package com.test.project.controller;

import com.test.project.entity.RolePermissionId;
import com.test.project.service.RoleService;
import com.test.project.util.JsonResult;
import com.test.project.util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;
    @RequestMapping("/table")
    @ResponseBody
    public JsonResult table(Query query){
        return JsonResult.packaging(roleService.table(query), Long.valueOf(roleService.count()),"");
    }
    /*
    * 权限角色添加，统一由此接口完成
    * */
    @RequestMapping("/add")
    @ResponseBody
    public String addRole(RolePermissionId rp){
        roleService.insert(rp);
        return "success";
    }
    /**/
    @RequestMapping("/update")
    @ResponseBody
    public String update(RolePermissionId rp){
        //System.out.println(rp.getRoleId()+"insert"+rp.getInsert().size()+"delete"+rp.getDelete());
        roleService.update(rp);
        return "success";
    }
    @RequestMapping("/permissionIds")
    @ResponseBody
    public List<Integer> roleGetPermissionIds(Integer roleId){
        return roleService.searchPermissionIds(roleId);
    }
}
