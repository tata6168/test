package com.test.project.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    Long userId;
    String userName;
    String password;
    Date registerTime;
    String portraitPath="/";
    boolean normalSign = true;
    List<Role> roleList = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", registerTime=" + registerTime +
                ", portraitPath='" + portraitPath + '\'' +
                ", normalSign=" + normalSign +
                ", roleList=" + roleList +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getRegisterTime() {
        return registerTime;
    }
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }
    public String getPortraitPath() {
        return portraitPath;
    }
    public void setPortraitPath(String portraitPath) {
        this.portraitPath = portraitPath;
    }
    public boolean isNormalSign() {
        return normalSign;
    }
    public void setNormalSign(boolean normalSign) {
        this.normalSign = normalSign;
    }

}
