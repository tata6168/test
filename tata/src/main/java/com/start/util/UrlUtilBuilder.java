package com.start.util;

import com.start.entity.Menu;
import com.start.entity.Permission;
import com.start.entity.RoleDetails;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UrlUtilBuilder {
    Map<String, RoleDetails> map;

    public UrlUtilBuilder(HashMap<String, RoleDetails> data) {
        map=data;
    }
    /*
     * status 1：页面跳转 0：待确定 -1：功能路径
     * */
    public void urlTransitionShiro(String u,int status) throws Exception {
        if(u==null|u.length()==0){
            throw new Exception("parameter allUrl not null");
        }
        //url format path/{param}
        if(u.indexOf("{")!=-1){
            u=u.substring(0,u.indexOf("{")-1);
        }
        StringBuilder builder = new StringBuilder();
        builder.append(u);
        //删除头尾 '/'
        if(builder.indexOf("/")==0)
            builder.deleteCharAt(0);
        int i = builder.length() - 1;
        if(builder.lastIndexOf("/")==i)
            builder.deleteCharAt(i);
        //拿出前缀做 RoleDetailsName
        String prefix = getUrlPrefix(builder);
        Permission permission = new Permission();
        Permission manager = null;
        Menu children = new Menu();
        Menu parent = null;
        if(map.containsKey(prefix)){
            permission.setPath(u);
            String s = replace(builder);
            permission.setPermissionName(s);
            permission.setSn(s);
            permission.setStatus(true);
            map.get(prefix).getPermissionList().add(permission);
            children.setSign(status);
            children.setTabName(snGetTabName(s));
            children.setMenuName(s);
            children.setPath(u);
            children.setStatus(true);
            List<Menu> menuList = map.get(prefix).getMenuList();
            menuList.get(menuList.size()-1).getChildrenList().add(children);
        }else {
            RoleDetails RoleDetails = new RoleDetails();
            //添加管理权限
            if(u. indexOf("/")!=-1) {
               manager = new Permission();
               manager.setSn(prefix+":*");
               manager.setPermissionName(prefix+":*");
               manager.setStatus(true);
               parent = new Menu();
               parent.setStatus(true);
               parent.setMenuName(prefix);
               parent.setSign(0);
               RoleDetails.getMenuList().add(parent);
               RoleDetails.getPermissionList().add(manager);
            }
            RoleDetails.setRoleName(prefix);
            RoleDetails.getPermissionList().add(permission);
            permission.setPath(u);
            String s = replace(builder);
            permission.setSn(s);
            permission.setPermissionName(s);
            children.setSign(status);
            children.setTabName(snGetTabName(s));
            children.setMenuName(s);
            children.setPath(u);
            children.setStatus(true);
            parent.getChildrenList().add(children);
            map.put(prefix,RoleDetails);
       }
       builder.setLength(0);
    }
    //替换 '/'
    private String replace(StringBuilder builder){
        if(builder.indexOf("/")==-1)
            return builder.insert(builder.length(),":*").toString();
        int y = 1;
        while (builder.indexOf("/")!=-1){
            builder.setCharAt(builder.indexOf("/",y),':');
            y++;
        }
        return builder.toString();
    }
    //prefix
    private String getUrlPrefix(StringBuilder builder){
        if(builder.indexOf("/")==-1)
            return builder.toString();
        return builder.substring(0,builder.indexOf("/"));
    }
    private String snGetTabName(String sn){
        String s = "";
        char[] chars = sn.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(i==0){
                s+=chars[i];
            }else if(chars[i]==':'){
                s+=chars[i+1];
            }else if(Character.isUpperCase(chars[i])){
                s+=chars[i];
            }
        }
        return s;
    }
}
