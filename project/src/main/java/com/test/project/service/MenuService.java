package com.test.project.service;

import com.test.project.entity.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getUserMenu(Long userId);
    List<Menu> getBatchRoleMenu(List<Integer> roleIds);
    void addMenu(Menu menu);
    void deleteMenu(Integer id);
    void updateMenu(Menu menu);
}
