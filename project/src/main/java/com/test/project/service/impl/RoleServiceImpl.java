package com.test.project.service.impl;

import com.test.project.entity.Role;
import com.test.project.entity.RolePermissionId;
import com.test.project.mapper.RoleMapper;
import com.test.project.service.RoleService;
import com.test.project.util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    public void insert(RolePermissionId rp ){

        if(rp.getRoleName()!=null && rp.getRoleName()!="")
            roleMapper.insert(rp);
        /*
        * 权限id非空判断
        * */
        if(rp.getPermissionIds()!=null)
            if(rp.getPermissionIds().size()!=0)
                roleMapper.roleAddPermission(rp);
    }

    @Override
    public List table(Query query) {
        return roleMapper.searchPage(query);
    }

    @Override
    public Integer count() {
        return roleMapper.count();
    }

    @Override
    public void update(RolePermissionId rp) {
        List<Integer> delete = rp.getDelete();
        List<Integer> insert = rp.getInsert();
        Integer roleId = rp.getRoleId();
        boolean in = delete.size() != 0;
        boolean de = insert.size() != 0;
        /*
        * 判断参数操作数据
        * */
        if(!in &&!de){
            roleMapper.deleteAllPermission(roleId);
        }else {
            if (in) {
                roleMapper.deletePermission(roleId, delete);
            }
            if (de) {
                roleMapper.insertPermission(roleId, insert);
            }
        }

    }

    @Override
    public List<Integer> searchPermissionIds(Integer id) {
        return roleMapper.searchPermissionIds(id);
    }

    @Override
    public List<Role> searchAll() {
        return roleMapper.searchAll();
    }


}
