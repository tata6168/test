package com.start.service.impl;

import com.start.entity.IntermediateDate;
import com.start.entity.Menu;
import com.start.mapper.MenuMapper;
import com.start.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
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
}
