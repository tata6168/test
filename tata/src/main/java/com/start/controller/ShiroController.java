package com.start.controller;

import com.start.entity.*;
import com.start.service.ShiroService;
import com.start.util.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("shiro")
public class ShiroController {
    @Autowired
    ShiroService shiroService;
    //查询用户
    @GetMapping("userAll")
    public ResultJson userAll(Query query){
        return shiroService.searchAllUser(query);
    }
    //获取用户角色穿梭狂
    @GetMapping("userRoleTransfer")
    public TransferEntity roleTransfer(Long userId){
        return shiroService.userRoleTransfer(userId);
    }
    @GetMapping("user/updateRole")
    public void userUpdateROle(IntermediateDate intermediateDate){
        intermediateDate.getInsert().forEach(e->{
            System.out.println("insert"+e);
        });
        intermediateDate.getDelete().forEach(d->{
            System.out.println("delete"+d);
        });
        shiroService.userUpdateRole(intermediateDate);
    }
    //查询role
    @GetMapping("roleAll")
    public ResultJson roleAll(Query query){ return shiroService.searchAllRole(query); }
    @GetMapping("rolePermissionTransfer")
    public TransferEntity rolePermissionTransfer(Integer roleId){

        return shiroService.rolePermissionTransfer(roleId);
    }
    //role更新permission
    @GetMapping("roleUpdatePermission")
    public void roleUpdatePermission(IntermediateDate intermediateDate){
        shiroService.roleUpdatePermission(intermediateDate);
    }
    //role查询permission n
    @GetMapping("roleSearchPermission")
    public List<Permission> roleSearchPermission(Integer roleId){
        return shiroService.searchPermissionByRole(roleId);
    }
    //查询permission
    @GetMapping("permissionAll")
    public ResultJson permissionAll(Query query){
        return shiroService.searchAllPermission(query);
    }
    @GetMapping("permission/update")
    public ResultJson permissionUpdate(PerModifiable perModifiable){
        shiroService.permissionUpdate(perModifiable);
        return ResultJson.success("success");
    }
    //禁用权限
    @GetMapping("permission/sst")
    public ResultJson permissionSst(Integer permissionId,Boolean status){
        shiroService.permissionSst(permissionId,status);
        return null;
    }
    //删除权限
    @DeleteMapping("delete/permission")
    public ResultJson permissionDelete(Integer permissionId){
        shiroService.deletePermission(permissionId);
        return ResultJson.success("permission delete success");
    }
    //插入User
    @GetMapping("user/insertOrUpdate")
    public void userInsertOrUpdate(User user){ shiroService.userInsertOrUpdate(user); }
    @GetMapping("user/deletes")
    public void userDeletes(long[] userIds){
        shiroService.userDeletes(userIds);
    }
    @GetMapping("user/delete")
    public void userDelete(long userId){
        shiroService.userDelete(userId);
    }
    //插入Role
    @GetMapping("role/insertOrUpdate")
    public void roleInsertOrUpdate(Role role){
        shiroService.roleInsertOrUpdate(role);
    }
    //插入Permission
    @GetMapping("permission/insertOrUpdate")
    public void permissionInsertOrUpdate(Permission permission){
        shiroService.permissionInsertOrUpdate(permission);
    }
    @GetMapping("permissionCount")
    public int permissionCount(){
        return shiroService.permissionCount();
    }
    @GetMapping("initPage")
    public PageData initPage(Long userId){
        List<Menu> ml=shiroService.userGetMenu(userId);
        ml.forEach(e->{
            for (Menu menu : e.getChildrenList()) {
                System.out.println(menu.getParentId());
            }
        });
        PageData data = new PageData();
        data.setMl(ml);
        return data;
    }
}
