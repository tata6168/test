package com.start.service;

import com.start.entity.IntermediateDate;
import com.start.entity.Menu;

import java.util.List;

public interface MenuService {
    /*
    * 跳转路径
    * 功能路径
    * */
    void insertOrUpdate(Menu menu);
    void roleMenuUpdate(IntermediateDate intermediateDate);
    List<Menu> searchMenuJava(Long userId);
    List<Menu> searchMenuSql(Long userId);
}
