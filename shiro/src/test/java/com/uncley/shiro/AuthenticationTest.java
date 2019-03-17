package com.uncley.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
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
public class AuthenticationTest {

    /**
     * 演示最简单的登录认证
     */
    // 使用一个简单的realm
    // 实际业务上我们经常是自定一个Realm，从数据库查询用户
    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before
    public void addUser() {
        simpleAccountRealm.addAccount("uncley", "123456");
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
        UsernamePasswordToken token = new UsernamePasswordToken("uncley", "123456");

        // 提交认证
        // 如果用户名或密码不对，login方法会抛出异常
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            // 应该对不同类型的异常进行处理
            e.printStackTrace();
        }

        System.out.println("认证结果：" + subject.isAuthenticated());

        // 退出登录
        subject.logout();
        System.out.println("认证结果：" + subject.isAuthenticated());

//        认证结果：true
//        认证结果：false
    }

}

