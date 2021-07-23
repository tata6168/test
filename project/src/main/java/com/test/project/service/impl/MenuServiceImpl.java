package com.test.project.service.impl;

import com.test.project.entity.Menu;
import com.test.project.mapper.MenuMapper;
import com.test.project.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;
    //获取用户拥有的菜单
    public List<Menu> getUserMenu(Long userId){
        return menuMapper.userGetMenu(userId);
    }
    //通过角色获取菜单
    public List<Menu> getBatchRoleMenu(List<Integer> roleIds){
        List<Menu> menus = menuMapper.roleBatchMenu(roleIds);
        int size = menus.size();
        HashMap<Integer, Menu> map1 = new HashMap<>();
        //找出一级菜单，添加子菜单到夫菜单中
        for (int i = 0; i < size; i++) {
            Menu menu = menus.get(i);
            Integer parentId = menu.getParentId();
            ArrayList<Menu> cache = new ArrayList<>();
            if(parentId==null){
                map1.put(menu.getMenuId(),menu);
            }else {
                if(map1.containsKey(parentId)){
                    //添加后移除从集合中移除子菜单元素
                    map1.get(parentId).getChildren().add(menu);
                    menus.remove(i);
                    size--;
                    i--;
                }
                map1.put(menu.getMenuId(),menu);
            }
        }
        //将余下的子菜单添加到父菜单中
        for (int i = 0; i < size; i++) {
            Menu menu = menus.get(i);
            Integer parentId = menu.getParentId();
            if(parentId!=null) {
                System.out.println(parentId+"/"+map1.get(parentId));
                map1.get(parentId).getChildren().add(menu);
                menus.remove(i);
                size--;
                i--;
            }

        }
        return menus;
    }

    @Override
    public void addMenu(Menu menu) {
        //写入数据库
        menuMapper.add(menu);
        //写入es

    }

    @Override
    public void deleteMenu(Integer id) {

    }

    @Override
    public void updateMenu(Menu menu) {

    }


}
