package com.uncley.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    // realm的作用是应用和数据的桥梁
    // realm的方法只要组装好数据即可，所以不要在realm的方法做过多的校验

    // 模拟数据库中的数据
    HashMap<String, String> users = new HashMap<>();

    {
        users.put("uncley", "123456");
    }


    /**
     * 授权查询
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 1,从主体传过来的认证信息中拿到username
        String username = (String) principalCollection.getPrimaryPrincipal();

        // 查询用户的role和权限
        Set<String> roles = getRolesFromDB(username);
        Set<String> permissions = getPermissionsFromDB(username);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(permissions);

        return simpleAuthorizationInfo;
    }

    // 模拟从数据库获取权限
    private Set<String> getPermissionsFromDB(String username) {
        Set<String> data = new HashSet<>();
        data.add("user:add");
        data.add("user:query");
        return data;
    }

    // 模拟从数据库拿权限
    private Set<String> getRolesFromDB(String username) {
        Set<String> data = new HashSet<>();
        data.add("admin");
        return data;
    }

    /**
     * 用户认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 1,从主体传过来的认证信息中拿到username
        String username = (String) authenticationToken.getPrincipal();

        // 2,通过用户名查询密码
        String password = getPasswdFromDB(username);
        // 如果不存在返回null
        if (null == password) {
            return null;
        }
        // 如果存在，返回AuthenticationInfo
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, "测试用户");
        // 这里我们只要组装一个正确的用户即可，shiro会为我们做密码的校验
        return authenticationInfo;
    }

    // 模拟数据库查询操作
    private String getPasswdFromDB(String username) {
        return users.get(username);
    }
}
