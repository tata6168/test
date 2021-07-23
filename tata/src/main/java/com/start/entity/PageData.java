package com.start.entity;

import java.util.ArrayList;
import java.util.List;

public class PageData {
    String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    List<Menu> ml=  new ArrayList<>();

    public List<Menu> getMl() {
        return ml;
    }

    public void setMl(List<Menu> ml) {
        this.ml = ml;
    }
}
