package com.yunsheng.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IniRealmTest {

    /**
     * 演示基于Ini文件的登录认证
     */
    IniRealm iniRealm = new IniRealm("classpath:user.ini");

    /**
     * [users]  // 必须这么写。用户 yunsheng=123456 [roles]  // 角色 admin=user:add 表示有admin角色，有user的add权限
     **/
    @Test
    public void testAuthentication() {
        // 1,构建SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(iniRealm);

        // 2,主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        // 构造认证请求
        UsernamePasswordToken token = new UsernamePasswordToken("yunsheng2", "123456");

        // 提交认证
        // 如果用户名或密码不对，login方法会抛出异常
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            // 应该对不同类型的异常进行处理
            e.printStackTrace();
        }

        System.out.println("认证结果：" + subject.isAuthenticated());

        // 检验角色
        try {
            subject.checkRole("admin");
        } catch (AuthorizationException e) {
            e.printStackTrace();
        }

        try {
            subject.checkRole("user");
        } catch (AuthorizationException e) {
            e.printStackTrace();
        }


        //校验权限
        try {
            subject.checkPermission("user:add");
        } catch (AuthorizationException e) {
            e.printStackTrace();
        }
        // 退出登录
        subject.logout();
        System.out.println("认证结果：" + subject.isAuthenticated());

    }

}

