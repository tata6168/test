package com.start.controller;

import com.start.entity.LogInfo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("user")
public class LogInOutRegisterController {
    @GetMapping("login")
    public String login(LogInfo info){
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
}
