package com.test.project.mapper;

import com.test.project.entity.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface PermissionMapper {
    void insert(Integer id);
    void update(Permission permission);
    void delete(Integer id);
    List<Permission> getAllSimple();
    List<Permission> batchSearch(@Param("paramName") ArrayList<Integer> paramName);

    List<Permission> getAllDetail();
}
