package com.test.project.entity;

import java.util.ArrayList;
import java.util.List;

public class RoleTransferInfo {
    List<Role> roleList = new ArrayList<>();
    List<Integer> userRoleIds = new ArrayList<>();

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public List<Integer> getUserRoleIds() {
        return userRoleIds;
    }

    public void setUserRoleIds(List<Integer> userRoleIds) {
        this.userRoleIds = userRoleIds;
    }
}
