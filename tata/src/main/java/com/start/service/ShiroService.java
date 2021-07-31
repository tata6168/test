package com.start.service;

import com.start.entity.*;
import com.start.util.ResultJson;

import java.util.List;
import java.util.Set;

public interface ShiroService {
    /*
    * 根据角色Id，到Map RoleSnCache.ROLE_ID_SN 获取Sn 如过没有就查询然后添加到缓存中
    * */
    Set<String> roleIdGetSn(Integer roleId);
    List<RoleDetails> shiroSnInit();
    LogInfo Login(String userId);
    Long permissionInsertOrUpdate(Permission permission);
    long roleInsertOrUpdate(Role role);
    Long addUser(User user) throws Exception;

    void updateRole(RoleDetails roleDetails);
    Long deleteRole(Integer roleId);

    Long deletePermission(Integer permissionId);


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

    Long userInsertOrUpdate(User user);

    void userDelete(long userId);
    void userDeletes(long[] userIds);

    TransferEntity userRoleTransfer(Long userId);

    TransferEntity rolePermissionTransfer(Integer roleId);

    void permissionSst(Integer permissionId, Boolean status);

    void permissionUpdate(PerModifiable map);
    UserDetails loginInfoLoad(Long userId);
    List<Menu> userGetMenu(Long userId);

}

