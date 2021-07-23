package com.test.project.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RolePermissionId {
    Integer roleId;
    String roleName;
    List<Integer> permissionIds = new ArrayList<>();
    List<Integer> insert = new ArrayList<>();
    List<Integer> delete = new ArrayList<>();


    public List<Integer> getInsert() {
        return insert;
    }

    public void setInsert(List<Integer> insert) {
        this.insert = insert;
    }

    public List<Integer> getDelete() {
        return delete;
    }

    public void setDelete(List<Integer> delete) {
        this.delete = delete;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(List<Integer> permissionIds) {
        this.permissionIds = permissionIds;
    }
}
