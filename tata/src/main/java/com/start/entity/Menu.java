package com.start.entity;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    /*
     * sign 1：页面跳转 0：待确定 -1：功能路径
     * */
    int sign;
    Integer parentId;
    Integer menuId;
    String menuName;
    String path;
    String tabName;
    boolean status;
    List<Menu> childrenList = new ArrayList<>();

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Menu> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<Menu> childrenList) {
        this.childrenList = childrenList;
    }
}
