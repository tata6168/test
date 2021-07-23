package com.test.project.service;

import com.test.project.entity.Permission;

import java.util.List;

public interface PermissionService {
    /*
    * true 权限详细信息
    * false 只返回permission_id和permission_name 角色权限穿梭框使用
    * */
    List<Permission> searchAll(boolean b);
}
