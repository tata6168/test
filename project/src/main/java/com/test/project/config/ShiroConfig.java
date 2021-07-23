package com.test.project.config;

import com.test.project.entity.User;
import com.test.project.mapper.PermissionMapper;
import com.test.project.mapper.UserMapper;
import com.test.project.service.UserService;
import com.test.project.util.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;

@Configuration
public class ShiroConfig {
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    PermissionMapper permissionMapper;
    @Bean("hashedCredentialsMatcher")
    public HashedCredentialsMatcher matcher(){
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        //algorithm:算法
        //iterations:迭代次数/重复
        //Stored Credentials Hex Encoded：存储凭证十六进制编码
        matcher.setHashAlgorithmName("MD5");
        matcher.setHashIterations(MD5Util.ENCRYPTION_NUM);
        //matcher.setStoredCredentialsHexEncoded(true);
        return matcher;
    }
    @Bean("AuthorizingRealm")
    public Realm getRealm(@Qualifier("hashedCredentialsMatcher")HashedCredentialsMatcher matcher){
        return new AuthorizingRealm() {
            @Override
            protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
                User user = (User) SecurityUtils.getSubject().getPrincipal();
                //获取用户所有角色Id
                SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
                List<String> strings = userService.userGetPermission(user.getUserId());
                info.addStringPermissions(strings);
                return info;
            }
            @Override
            protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
                UsernamePasswordToken token1 = (UsernamePasswordToken) token;
                String username = token1.getUsername();
                User user = userMapper.searchByName(username);
                if(user==null)
                    return null;
                ByteSource salt = ByteSource.Util.bytes(MD5Util.SALT);
                SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),salt,"AuthorizingRealm");
                return info;
            }
            @Override
            public String getName() {
                return "AuthorizingRealm";
            }
            @Override
            public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
                super.setCredentialsMatcher(matcher);
            }
        };
    }
    @Autowired
    SecurityManager securityManager;
    @Bean("webSecurityManager")
    public DefaultWebSecurityManager getSecurityManager(@Qualifier("AuthorizingRealm")Realm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }
    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager( securityManager);
//        factoryBean.setSuccessUrl("/success");
//        factoryBean.setLoginUrl("/login.html");
        HashMap<String, String> map = new HashMap<>();
//        List<Permission> permissions = permissionMapper.getAll();
//        permissions.forEach(e->{
//            if(e.getPath()!=null&&e.getPath()!="") {
//                String sn = "";
//                if(e.getPath().endsWith("login")) {
//                    sn = "anon";
//                }else if(e.getPath().endsWith("user/register")){
//                    sn = "anon";
//                }else if(e.getPath().endsWith("forward/main")){
//                    sn = "anon";
//                }else {
//                    sn="perms[" + e.getSn() + "]";
//                }
//                map.put(e.getPath(), sn);
//            }
//        });
//        map.put("shiro/sessioninfo","anon");
//        map.put("/templates/*","anon");
//        map.put("/role/cache","anon");
        map.put("*/**","anon");
        factoryBean.setFilterChainDefinitionMap(map);
        return factoryBean;
    }
}