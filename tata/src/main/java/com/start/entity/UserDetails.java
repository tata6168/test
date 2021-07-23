package com.start.entity;

import java.util.ArrayList;
import java.util.List;

public class UserDetails extends User {
    List<RoleDetails> roleDetailsList = new ArrayList<>();

    public List<RoleDetails> getRoleDetailsList() {
        return roleDetailsList;
    }

    public void setRoleDetailsList(List<RoleDetails> roleDetailsList) {
        this.roleDetailsList = roleDetailsList;
    }
}