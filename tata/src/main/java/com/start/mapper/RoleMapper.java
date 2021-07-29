package com.start.mapper;

import com.start.entity.NameId;
import com.start.entity.Query;
import com.start.entity.Role;
import com.start.entity.RoleDetails;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface RoleMapper {
    List<RoleDetails> shiroInit();
    Integer searchPermissionCount(Integer roleId);
    void deleteAllPermission(Integer roleId);
    void addPermission(@Param("roleId") Number roleId,@Param("permissionIds") List<Number> insert);
    void deletePermission(@Param("roleId")Number roleId,@Param("permissionIds")List<Number> insert);
    List<Role> selectAll(Query query);
    void insert(Role role);
    void update(Role role);
    void delete(Integer roleId);

    long count();
    List<NameId> transfer();

    List<Integer> getPermissionIds(Integer roleId);

    RoleDetails roleIdGetSn(Integer roleId);
}
