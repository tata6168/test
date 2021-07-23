package com.start.entity;

import java.util.ArrayList;
import java.util.List;

public class RoleUpdatePermissionId extends Role {
    List<Integer> delete = new ArrayList<>();
    List<Integer> add = new ArrayList<>();

    public List<Integer> getDelete() {
        return delete;
    }

    public void setDelete(List<Integer> delete) {
        this.delete = delete;
    }

    public List<Integer> getAdd() {
        return add;
    }

    public void setAdd(List<Integer> add) {
        this.add = add;
    }
}
