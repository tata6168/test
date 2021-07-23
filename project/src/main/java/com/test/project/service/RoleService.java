package com.test.project.service;

import com.test.project.entity.Role;
import com.test.project.entity.RolePermissionId;
import com.test.project.util.Query;

import java.util.List;

public interface RoleService {
    void insert(RolePermissionId rp );

    List table(Query query);

    Integer count();

    void update(RolePermissionId rp);

    List<Integer> searchPermissionIds(Integer id);

    List<Role> searchAll();
}
