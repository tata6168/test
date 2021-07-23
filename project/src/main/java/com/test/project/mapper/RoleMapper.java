package com.test.project.mapper;

import com.test.project.entity.Role;
import com.test.project.entity.RolePermissionId;
import com.test.project.util.Query;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    List<String> getSn(Integer roleId);

    void insert(RolePermissionId role);

    Integer count();

    void roleAddPermission(RolePermissionId rp);

    List<Role> searchPage(Query query);

    void update(RolePermissionId rp);
    /*
    * 删除角色，删除中间表
    * */
    void deleteRole(Integer roleId);
    /*
    * 删除角色所有权限
    * */
    void deleteAllPermission(Integer roleId);

    void deletePermission(RolePermissionId rp);

    List<Integer> searchPermissionIds(Integer id);

    void insertPermission(@Param("roleId") Integer roleId, @Param("insert") List<Integer> insert);
    /*
     * 删除角色部分权限
     * */
    void deletePermission(@Param("roleId")Integer roleId, @Param("delete")List<Integer> delete);

    List<Role> searchAll();
}
