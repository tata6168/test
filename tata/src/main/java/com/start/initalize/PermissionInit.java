package com.start.initalize;

import com.start.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import com.start.mapper.UnifyMapper;
import com.start.service.MenuService;
import com.start.service.ShiroService;
import com.start.util.UrlUtilBuilder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PermissionInit implements ApplicationRunner {
    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    ShiroService shiroService;
    @Autowired
    MenuService menuService;
    @Autowired
    UnifyMapper unifyMapper;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(true) {
            developPermissionIMenuInit();
        }
    }
/*
* 根据所有Controller上的路径来创建permission/role/menu
* 并创建一个超级用户
* username：root
* passwords：123456
* */
    public void developPermissionIMenuInit(){
        if(unifyMapper.searchRoot()>0){
            unifyMapper.deleteUserRoot();
        }
        //超级用户，存储所有roleId
        ArrayList<Number> l = new ArrayList<>();
        unifyMapper.initShiroTable();
        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = mapping.getHandlerMethods();
        //拿到所有url
        HashMap<String, RoleDetails> data = new HashMap<>();
        UrlUtilBuilder builder = new UrlUtilBuilder(data);
        handlerMethods.entrySet().forEach(e -> {
            e.getKey().getPatternsCondition().getPatterns().forEach(u -> {
                Method method = e.getValue().getMethod();
                Class<?> declaringClass = method.getDeclaringClass();
                /*
                 * status 1：页面跳转 0：待确定 -1：功能路径
                 * */
                int status=1;
                RestController rest = declaringClass.getDeclaredAnnotation(RestController.class);
                Controller controller = declaringClass.getDeclaredAnnotation(Controller.class);
                ResponseBody body = method.getDeclaredAnnotation(ResponseBody.class);
                Class<?> returnType = method.getReturnType();
                if(returnType==ModelAndView.class){
                    System.out.println(method.getName());
                    status=0;
                }else if(rest!=null){
                    status=-1;
                }else if(body!=null){
                    status=-1;
                }
                try {
                    builder.urlTransitionShiro(u,status);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
        });

        data.entrySet().forEach(e -> {
            //添加角色
            shiroService.roleInsertOrUpdate(e.getValue());
            //添加roleId
            l.add(e.getValue().getRoleId());
            List<Number> integers = new ArrayList<>();
            List<Menu> mL = e.getValue().getMenuList();
            List<Permission> pL = e.getValue().getPermissionList();
            Integer parentId = null;
            Menu mp = mL.get(0);
            menuService.insertOrUpdate(mp);
            parentId = mp.getMenuId();
            for (Menu c : mp.getChildrenList()) {
                c.setParentId(parentId);
                menuService.insertOrUpdate(c);
            }

            for (int i = 0; i < pL.size(); i++) {
                Permission p = pL.get(i);
                shiroService.permissionInsertOrUpdate(p);
                integers.add(p.getPermissionId());
            }
            //添加中间表
            IntermediateDate date = new IntermediateDate();
            date.setMainId(e.getValue().getRoleId());
            date.setInsert(integers);
            date.setSign(1);
//添加role/permission中间表
            shiroService.roleUpdatePermission(date);
//添加role/menu中间表
            menuService.roleMenuUpdate(date);
        });
//创建超级用户
        User user = new User();
        user.setUserName("root");
        user.setPasswords("123456");
        shiroService.userInsertOrUpdate(user);
        IntermediateDate date = new IntermediateDate();
        date.setSign(1);
        date.setMainId(Math.toIntExact(user.getUserId()));
        date.setInsert(l);
        shiroService.userUpdateRole(date);
    }


}
