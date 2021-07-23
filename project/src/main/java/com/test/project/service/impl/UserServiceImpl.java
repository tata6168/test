package com.test.project.service.impl;

import com.test.project.config.PermissionCache;
import com.test.project.entity.TransferUpdateInfo;
import com.test.project.entity.User;
import com.test.project.mapper.RoleMapper;
import com.test.project.mapper.UserMapper;
import com.test.project.service.MenuService;
import com.test.project.service.UserService;
import com.test.project.util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<User> searchPage(Query query) {
        List<User> table = userMapper.table(query);
        return userMapper.table(query);
    }

    @Override
    public Long count() {
        return userMapper.count();
    }

    @Override
    public List<String> userGetPermission(Long userId) {
        List<Integer> integers = userMapper.userGetRoleId(userId);
        ArrayList<String> data = new ArrayList<>();
        for (Integer id : integers) {
            if(PermissionCache.verify(id)){
                //先到缓存中获取数据
                data.addAll(PermissionCache.ROLE_SN.get(id));

            }else {
                //拿不到再到数据库中获取
                List<String> sn = roleMapper.getSn(id);
                data.addAll(sn);
                PermissionCache.ROLE_SN.put(id,sn);
            }
        }
        return data;
    }

    @Override
    public void register(User user) {
        userMapper.insert(user);
    }

    @Override
    public List<Integer> searchRoleIds(Long userId) {
        return userMapper.userGetRoleId(userId);
    }

    @Override
    public void updateRole(TransferUpdateInfo info) {
        List<Number> delete = info.getDelete();
        List<Number> insert = info.getInsert();
        boolean del = delete.size() != 0;
        boolean in = insert.size() != 0;
        if(del&&in){
            userMapper.deleteRole(info.getPrimaryId(),delete);
            userMapper.insertRole(info.getPrimaryId(),insert);
        }else if(del){
            userMapper.deleteRole(info.getPrimaryId(),delete);
        }else if(in) {
            userMapper.insertRole(info.getPrimaryId(),insert);
        }else {
            userMapper.deleteAllRole(info.getPrimaryId());
            return;
        }
    }
}
