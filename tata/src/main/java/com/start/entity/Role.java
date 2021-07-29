package com.start.entity;

import java.util.HashSet;
import java.util.Set;

public class Role {
    Integer roleId;
    String roleName;
    String description;
    Set<String> snSet = new HashSet<>();

    public Set<String> getSnSet() {
        return snSet;
    }

    public void setSnSet(Set<String> snSet) {
        this.snSet = snSet;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
