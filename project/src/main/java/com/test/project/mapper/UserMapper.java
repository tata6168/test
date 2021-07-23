package com.test.project.mapper;

import com.test.project.entity.User;
import com.test.project.util.Query;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> table(Query query);
    Long count();
    void insert(User user);
    List<Integer> userGetRoleId(Long userId);
    List<String> userGetPermission(Long userId);
    User searchByName(String userName);

    void deleteRole(@Param("primaryId") Number primaryId,@Param("delete") List<Number> delete);

    void insertRole(@Param("primaryId") Number primaryId,@Param("insert") List<Number> insert);

    void deleteAllRole(Number primaryId);
}
