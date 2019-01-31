package com.yunsheng.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 演示密码是加密存储的情况
 */
public class MyMd5Realm extends AuthorizingRealm {
    // realm的作用是应用和数据的桥梁
    // realm的方法只要组装好数据即可，所以不要在realm的方法做过多的校验

    // 模拟数据库中的数据
    HashMap<String, String> users = new HashMap<>();

    {
        users.put("yunsheng", "35598a647ec3ddb94b9d2a7dcdd8124e");
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
        // 这里注意要把盐传回去
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("good"));
        return authenticationInfo;
    }

    // 模拟数据库查询操作
    private String getPasswdFromDB(String username) {
        return users.get(username);
    }


    public static void main(String[] args) {
        // 一般需要加随机数盐，确保安全
        Md5Hash md5Hash = new Md5Hash("123456", "good");
        System.out.println(md5Hash.toString());
    }
}
