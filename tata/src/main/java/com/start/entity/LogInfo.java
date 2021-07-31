package com.start.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LogInfo {
    String userId;
    String passwords;
    Integer roleId;
    Set<String> snSet = new HashSet<>();

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Set<String> getSnSet() {
        return snSet;
    }

    public void setSnSet(Set<String> snSet) {
        this.snSet = snSet;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    @Override
    public String toString() {
        return "LogInfo{" +
                "userId='" + userId + '\'' +
                ", passwords='" + passwords + '\'' +
                ", roleId=" + roleId +
                ", snSet=" + snSet +
                '}';
    }
}
