package com.start.controller;

import com.start.entity.LogInfo;

import com.start.entity.User;
import com.start.service.ShiroService;
import com.start.util.ResultJson;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("user")
public class LogInOutRegisterController {
    @Autowired
    ShiroService shiroService;
    @GetMapping("login")
    public String login(LogInfo info){
        System.out.println(info);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(info.getUserId(), info.getPasswords());
        try{
            subject.login(token);
        }catch (UnknownAccountException e){
            e.printStackTrace();
            return "用户名错误";
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            return "密码错误";
        }catch (AuthenticationException e){
            e.printStackTrace();
            return "系统维护";
        }
        return "登录成功";
    }
    @PutMapping("register")
    public ResultJson register(User user){
        try {
            shiroService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultJson.success("系统维护");
        }
        return ResultJson.success("注册成功");
    }
}
