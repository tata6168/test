package com.start.configuration;

import com.start.cache.RoleSnCache;
import com.start.entity.LogInfo;
import com.start.service.ShiroService;
import com.start.util.UserPasswordsEncrypt;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class ShiroConfig {
    final String REALM_NAME ="TestRealm";
    @Autowired
    ShiroService shiroService;

    @Bean("credentialsMatcher")
    public HashedCredentialsMatcher credentialsMatcher(){
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("MD5");
        matcher.setHashIterations(10);
        return matcher;
    }

    @Bean("AuthorizingRealm")
    public Realm realm(@Qualifier("credentialsMatcher") HashedCredentialsMatcher matcher){
        AuthorizingRealm authorizingRealm = new AuthorizingRealm() {
            @Override
            protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
                SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
                LogInfo logInfo = (LogInfo) SecurityUtils.getSubject().getPrincipal();
                info.setStringPermissions(logInfo.getSnSet());
                return info;
            }

            @Override
            protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
                UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
                String username = token.getUsername();
                LogInfo login = shiroService.Login(username);
                if (login == null) return null;
                //注入sn
                login.setSnSet(RoleSnCache.ROLE_ID_SN.get(login.getRoleId()));
                ByteSource source = ByteSource.Util.bytes(UserPasswordsEncrypt.SALT);
                SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, login, source, REALM_NAME);
                return info;
            }

            @Override
            public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
                super.setCredentialsMatcher(matcher);
            }
        };
        authorizingRealm.setName(REALM_NAME);
        return authorizingRealm;
    }
    @Bean("DefaultWebSecurityManager")
    public DefaultWebSecurityManager securityManager(@Qualifier("AuthorizingRealm")Realm realm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(realm);
        return manager;

    }
    @Bean("ShiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("DefaultWebSecurityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);

        factoryBean.setSuccessUrl("/success");
        factoryBean.setLoginUrl("/login");
        HashMap<String, String> map = new HashMap<>();
        int count = shiroService.roleMapperCount();
//        shiroService.
        //map.put("/**","anon");
//        shiroService.
//        List<Permission> permissions = permissionService.baseSearchAll();
//        permissions.forEach(e->{
//            if(e.getPath()!=null&&e.getPath()!="")
//                map.put(e.getPath(),"perms["+e.getSn()+"]");
//        });
        factoryBean.setFilterChainDefinitionMap(map);
        return factoryBean;
    }
}
