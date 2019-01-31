package com.yunsheng.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthenticationRoleTest {

    /**
     * 演示最简单的登录认证+角色
     */
    // 使用一个简单的realm
    // 实际业务上我们经常是自定一个Realm，从数据库查询用户
    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before
    public void addUser() {
        simpleAccountRealm.addAccount("yunsheng", "123456", "admin", "DBA");
    }


    @Test
    public void testAuthentication() {
        // 1,构建SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        // 2,主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        // 构造认证请求
        UsernamePasswordToken token = new UsernamePasswordToken("yunsheng", "123456");

        // 提交认证
        // 如果用户名或密码不对，login方法会抛出异常
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            // 应该对不同类型的异常进行处理
            e.printStackTrace();
        }

        System.out.println("认证结果：" + subject.isAuthenticated());

        try {
            // 会报异常，大小写敏感
            subject.checkRoles("admin", "dba");
        } catch (AuthorizationException e) {
            e.printStackTrace();
        }

        // 退出登录
        subject.logout();
        System.out.println("认证结果：" + subject.isAuthenticated());

    }

}

