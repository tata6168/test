package com.test.project.service.impl;

import com.test.project.ProjectStart;
import com.test.project.entity.Menu;
import com.test.project.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = ProjectStart.class)
class MenuServiceImplTest {
    @Autowired
    MenuService menuService;
    @Test
    void getUserMenu() {
        List<Menu> userMenu = menuService.getUserMenu(1l);
        userMenu.forEach(p->{
            System.out.println(p.getMenuId());
            System.out.println(p.getMenuName());
            p.getChildren().forEach(c->{
                System.out.println("c:"+c.getMenuId());
                System.out.println("c:"+c.getMenuName());
                System.out.println("c:"+c.getParentId());
                c.getChildren().forEach(g->{
                    System.out.println("g:"+g.getMenuId());
                    System.out.println("g:"+g.getMenuName());
                    System.out.println("g:"+g.getParentId());
                });
            });
        });
    }

    @Test
    void getBatchRoleMenu() {
        List<Menu> userMenu = menuService.getBatchRoleMenu(Arrays.asList(1));
        System.out.println("size:"+userMenu.size());
        userMenu.forEach(p->{
            System.out.println(p.getMenuId());
            System.out.println(p.getMenuName());
            p.getChildren().forEach(c->{
                System.out.println("c:"+c.getMenuId());
                System.out.println("c:"+c.getMenuName());
                System.out.println("c:"+c.getParentId());
                c.getChildren().forEach(g->{
                    System.out.println("g:"+g.getMenuId());
                    System.out.println("g:"+g.getMenuName());
                    System.out.println("g:"+g.getParentId());
                });
            });
        });
    }
}