package com.start.service.impl;

import com.start.cache.RoleSnCache;
import com.start.entity.*;
import com.start.mapper.*;
import com.start.service.ShiroService;
import com.start.service.UnifyService;
import com.start.util.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    PermissionMapper permissionMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    UnifyMapper unifyMapper;
    @Autowired
    UnifyService unifyService;

    @Override
    public Set<String> roleIdGetSn(Integer roleId) {
        if(RoleSnCache.ROLE_ID_SN.containsKey(roleId)) {
            return RoleSnCache.ROLE_ID_SN.get(roleId);
        }else {
             roleMapper.roleIdGetSn(roleId);
            return null;
        }
    }

    @Override
    public List<RoleDetails> shiroSnInit() {
        return roleMapper.shiroInit();
    }

    @Override
    public LogInfo Login(String userId) {
        LogInfo info = userMapper.getLogInfoById(userId);
        if(info==null) return null;
        if(info.getRoleId()==null){
            RoleSnCache.ROLE_ID_SN.entrySet().forEach(e->info.getSnSet().addAll(e.getValue()));
        }else {
            info.setSnSet(RoleSnCache.ROLE_ID_SN.get(info.getRoleId()));
        }
        return info;
    }

    @Override
    @CachePut(cacheNames = "count",key = "'t_permission'",condition = "#permission.permissionId==null")
    public Long permissionInsertOrUpdate(Permission permission) {
        Integer permissionId = permission.getPermissionId();
        Long count=null;
        if(permissionId==null){
            permissionMapper.insert(permission);
            count=unifyService.count("t_permission")+1;
        }else {
            permissionMapper.update(permission);
        }
        return count;
    }

    @Override
    @CachePut(cacheNames = "count",key = "'t_role'",condition = "#role.roleId==null")
    public long roleInsertOrUpdate(Role role) {
        Integer roleId = role.getRoleId();
        long count=0l;
        if(roleId==null){
            count=unifyService.count("t_role")+1;
            roleMapper.insert(role);
        }else {
            roleMapper.update(role);
        }
        return count;
    }

    @Override
    @CachePut(cacheNames = "count",key = "'t_user'")
    public Long addUser(User user) throws Exception {
        if(RoleSnCache.registerInitRoleId==null)
            throw new Exception("Parameter RoleSnCache.registerInitRoleId is Null");
        user.setRoleId(RoleSnCache.registerInitRoleId);
        userMapper.insert(user);
        return unifyService.count("t_user")+1;
    }

    @Override
    public void updateRole(RoleDetails roleDetails) {

    }

    @Override
    @CachePut(cacheNames = "count",key = "'t_role'")
    public Long deleteRole(Integer roleId) {
        roleMapper.delete(roleId);
        if(roleMapper.searchPermissionCount(roleId)>0)
            roleMapper.deleteAllPermission(roleId);
        return unifyService.count("t_role")-1;
    }

    @Override
    @CachePut(cacheNames = "count",key = "'t_permission'")
    public Long deletePermission(Integer permissionId) {
        permissionMapper.delete(permissionId);
        return unifyService.count("t_permission");
    }

    @Override
    public void userUpdateRole(IntermediateDate intermediateDate) {
        int sign = intermediateDate.getSign();

        switch(sign){
            case 1:
                userMapper.insertRole(intermediateDate);
                break;
            case -1:
                userMapper.deleteRole(intermediateDate);
                break;
            default:
                userMapper.insertRole(intermediateDate);
                userMapper.deleteRole(intermediateDate);
        }
    }

    @Override
    @Transactional
    public void roleUpdatePermission(IntermediateDate intermediateDate) {
        int sign = intermediateDate.getSign();
        switch(sign){
            case 1:
                roleMapper.addPermission(intermediateDate.getMainId(),intermediateDate.getInsert());
                break;
            case -1:
                roleMapper.deletePermission(intermediateDate.getMainId(),intermediateDate.getDelete());
                break;
            default:
                roleMapper.addPermission(intermediateDate.getMainId(),intermediateDate.getInsert());
                roleMapper.deletePermission(intermediateDate.getMainId(),intermediateDate.getDelete());
        }
    }

    @Override
    public ResultJson searchAllRole(Query query) {
        return ResultJson.result(roleMapper.selectAll(query),roleMapper.count());
    }

    @Override
    public List<Role> searchRoleByUser(Integer id) {
        return null;
    }

    @Override
    public ResultJson searchAllPermission(Query query) {
        return ResultJson.result(permissionMapper.selectAll(query),permissionMapper.count());
    }

    @Override
    public List<Permission> searchPermissionByRole(Integer roleId) {
        return null;
    }

    @Override
    public ResultJson searchAllUser(Query query) {
        return ResultJson.result(userMapper.searchAllUser(query),unifyMapper.count("t_user"));
    }

    @Override
    public int permissionCount() {
        return (int) unifyMapper.count("t_permission");
    }

    @Override
    public int roleMapperCount() {
        return (int) unifyMapper.count("t_role");
    }

    @Override
    public long userCount() {
        return unifyMapper.count("t_user");
    }

    @Override
    @CachePut(key = "'t_user'",cacheNames = "count",condition = "#user.userId==null")
    public Long userInsertOrUpdate(User user) {
        if(user.getUserId()==null){
            userMapper.insert(user);
        }else {
            userMapper.update(user);
        }
        return unifyService.count("t_user")+1;
    }

    @Override
    public void userDelete(long userId) {
        userMapper.delete(userId);
    }

    @Override
    public void userDeletes(long[] userIds) {
        userMapper.deletes(userIds);
    }

    @Override
    public TransferEntity userRoleTransfer(Long userId) {
        List<NameId> transfer = roleMapper.transfer();
        List<Integer> roleId = userMapper.getRoleId(userId);
        TransferEntity transferEntity = new TransferEntity();
        transferEntity.setIds(roleId);
        transferEntity.setNameIdList(transfer);
        return transferEntity;
    }

    @Override
    public TransferEntity rolePermissionTransfer(Integer roleId) {
        List<Integer> pIds= roleMapper.getPermissionIds(roleId);
        List<NameIdPer> nameIdPers = permissionMapper.roleTransferInfo();
        TransferEntity transferEntity = new TransferEntity();
        transferEntity.setIds(pIds);
        transferEntity.setNameIdList(nameIdPers);
        return transferEntity;
    }

    @Override
    public void permissionSst(Integer permissionId, Boolean status) {
        if(status!=null){
            permissionMapper.sst(permissionId,status);
        }else {
            throw new IllegalArgumentException("parameter status is null");
        }
    }

    @Override
    public void permissionUpdate(PerModifiable map) {
        permissionMapper.update(map);
    }

    @Override
    public UserDetails loginInfoLoad(Long userId) {
        List<Integer> roleId = userMapper.getRoleId(userId);
        userMapper.getPermission(roleId);
        userMapper.getMenu(roleId);
        return null;
    }

    @Override
    public List<Menu> userGetMenu(Long userId) {
        List<Integer> roleId = userMapper.getRoleId(userId);
        return userMapper.getMenu(roleId);
    }
}
