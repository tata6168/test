package com.start.entity;

import java.util.ArrayList;
import java.util.List;

public class RoleDetails extends Role {
    List<Permission> permissionList = new ArrayList<>();
    List<Menu> menuList = new ArrayList<>();
    public List<Menu> getMenuList() {
        return menuList;
    }
    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }
    public List<Permission> getPermissionList() {
        return permissionList;
    }
    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
}
