package com.start.service.impl;

import com.start.entity.IntermediateDate;
import com.start.entity.Menu;
import com.start.entity.Path;
import com.start.mapper.MenuMapper;
import com.start.mapper.PathMapper;
import com.start.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    PathMapper pathMapper;
    @Autowired
    MenuMapper menuMapper;
    @Override
    public void insertOrUpdate(Menu menu) {
        Integer menuId = menu.getMenuId();
        if(menuId==null){
            menuMapper.insert(menu);
        }else {
            menuMapper.update(menu);
        }
    }
    @Override
    public void roleMenuUpdate(IntermediateDate intermediateDate) {
        int sign = intermediateDate.getSign();
        if(sign==1||sign==0){
            menuMapper.roleAddMenu(intermediateDate);
        }else if(sign==-1||sign==0){
            menuMapper.roleDeleteMenu(intermediateDate);
        }
    }
    @Override
    public List<Menu> searchMenuJava(Long userId) {
        List<Menu> menus = menuMapper.searchMenuJava(userId);
        return null;
    }

    @Override
    public List<Menu> searchMenuSql(Long userId) {
        menuMapper.searchMenuSql(userId);
        return null;
    }

    @Override
    public List<Menu> getAllMenu() {
        List<Menu> allMenu = menuMapper.getAllMenu();
        HashMap<Integer, List<Menu>> map = new HashMap<>();
        int size = allMenu.size();
        for ( int i=0;i<size;i++) {
            Menu c=allMenu.get(i);
            Integer parentId = c.getParentId();
            Integer menuId = c.getMenuId();
            if(parentId==null){
            //顶级菜单
                if(map.containsKey(menuId)) {
                    c.setChildrenList(map.get(menuId));
                }else {
                    map.put(menuId,c.getChildrenList());
                }
            }else {
                if(map.containsKey(parentId)) {
                    map.get(parentId).add(c);
                }else {
                //次级菜单创建父级key到map
                    List<Menu> cl = new ArrayList<>();
                    cl.add(c);
                    map.put(parentId,cl);
                }
            }
        }
        for (int i = 0; i < size; i++) {
            Menu c=allMenu.get(i);
            Integer parentId = c.getParentId();
            Integer menuId = c.getMenuId();
            boolean pb = map.containsKey(menuId);
            //菜单存在次级集合
            if(pb){
                //当前菜单的子级菜单是否添加到子菜单集合
                if(c.getChildrenList().size()==0)
                    c.setChildrenList(map.get(menuId));
            }
            //不为顶级菜单、删除集合中的菜单对象
            if(parentId!=null){
                allMenu.remove(i);
                i--;
                size--;
            }
        }
        return allMenu;
    }

    @Override
    public List<Path> getAllPath() {
        return pathMapper.select();
    }
}
