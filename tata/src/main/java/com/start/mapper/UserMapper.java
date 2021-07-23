package com.start.mapper;

import com.start.entity.*;
import org.apache.ibatis.annotations.Param;
import com.start.entity.*;

import java.util.List;

public interface UserMapper {
    List<User> searchAllUser(Query query);
    void deleteRole(IntermediateDate intermediateDate);
    void insertRole(IntermediateDate intermediateDate);

    void insert(User user);

    void update(User user);

    void delete(long userId);

    void deletes(@Param("userIds") long[] userIds);

    List<Integer> getRoleId(Long userId);

    TransferEntity procedureUserRoleTransfer(Long userId);

    List<NameId> roleAlls(Long userId);
//    <select id="searchUserRoleIds" resultType="Integer">
//    SELECT role_id FROM user_role WHERE user_id = 10
//            </select>
//    <select id="mapTest" resultMap="roleAll">
    TransferEntity searchUserRoleIdsTransfer(Long userId);


    List<Permission> getPermission(List<Integer> roleId);

    List<Menu> getMenu(@Param("roleId") List<Integer> roleId);
}
