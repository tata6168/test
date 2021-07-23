package com.test.project.entity;

import java.util.ArrayList;
import java.util.List;

public class RolePermissionInfo extends Role  {
    List<Permission> permissionList = new ArrayList<>();
    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
}
