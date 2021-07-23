package com.start.service;

import com.start.entity.*;
import com.start.util.ResultJson;

import java.util.List;

public interface ShiroService {
    void permissionInsertOrUpdate(Permission permission);
    void roleInsertOrUpdate(Role role);
    void addUser(User user);

    void updateRole(RoleDetails roleDetails);
    void deleteRole(Integer roleId);

    void deletePermission(Integer permissionId);


    void userUpdateRole(IntermediateDate intermediateDate);
    void roleUpdatePermission(IntermediateDate intermediateDate);

    ResultJson searchAllRole(Query query);
    List<Role> searchRoleByUser(Integer id);

    ResultJson searchAllPermission(Query query);
    List<Permission> searchPermissionByRole(Integer roleId);

    ResultJson searchAllUser(Query query);

    int permissionCount();
    int roleMapperCount();
    long userCount();

    void userInsertOrUpdate(User user);

    void userDelete(long userId);
    void userDeletes(long[] userIds);

    TransferEntity userRoleTransfer(Long userId);

    TransferEntity rolePermissionTransfer(Integer roleId);

    void permissionSst(Integer permissionId, Boolean status);

    void permissionUpdate(PerModifiable map);
    UserDetails loginInfoLoad(Long userId);
    List<Menu> userGetMenu(Long userId);

}

