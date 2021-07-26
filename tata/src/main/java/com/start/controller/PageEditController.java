package com.start.controller;

import com.start.entity.Menu;
import com.start.entity.Path;
import com.start.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("page")
public class PageEditController {
    @Autowired
    MenuService menuService;
    @GetMapping("menu/insertOrUpdate")
    public void sideMenuEdit(Menu menu){
        menuService.insertOrUpdate(menu);
    }
    @GetMapping("allMenu")
    public List<Menu> getAllMenu(){
        List<Menu> ml = menuService.getAllMenu();
        return ml;
    }
    @GetMapping("allPath")
    public List<Path> getAllPath(){
        return menuService.getAllPath();
    }
    @DeleteMapping("del/menu")
    public void delMenu(int[] menuIds){
        menuService.delMenu(menuIds);
    }
}
