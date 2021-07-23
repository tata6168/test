package com.test.project.service.impl;

import com.test.project.entity.Permission;
import com.test.project.mapper.PermissionMapper;
import com.test.project.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper;
    public List<Permission> searchAll(boolean b){
        if(b){
            return permissionMapper.getAllDetail();
        }else {
            return permissionMapper.getAllSimple();
        }
    }
}
