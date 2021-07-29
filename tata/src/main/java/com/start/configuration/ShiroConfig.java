package com.start.configuration;

import com.start.cache.RoleSnCache;
import com.start.entity.LogInfo;
import com.start.entity.Role;
import com.start.entity.RoleDetails;
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
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.*;

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

    @Bean("authorizingRealm")
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
            //注入sn 缓存中获取
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
    public DefaultWebSecurityManager securityManager(@Qualifier("authorizingRealm")Realm realm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(realm);
        return manager;

    }
    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("DefaultWebSecurityManager")DefaultWebSecurityManager manager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(manager);

        HashMap<String, String> map = new HashMap<>();
        List<RoleDetails> roleDetails = shiroService.shiroSnInit();
//角色id，sn缓存map
        for (RoleDetails role : roleDetails) {
            Map<Integer, Set<String>> roleIdSn = RoleSnCache.ROLE_ID_SN;
            Integer roleId = role.getRoleId();
            if(!roleIdSn.containsKey(roleId)){
                roleIdSn.put(roleId,new HashSet<String>());
            }
            role.getPermissionList().forEach(e->{
                roleIdSn.get(roleId).add(e.getSn());
                if(e.getPath()!=null&&e.getPath()!="")
                    map.put(e.getPath(),"perms["+e.getSn()+"]");
            });
        }

        factoryBean.setFilterChainDefinitionMap(map);
        return factoryBean;
    }
}
