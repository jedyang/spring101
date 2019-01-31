package com.yunsheng.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyMd5RealmTest {

    MyMd5Realm myRealm = new MyMd5Realm();

    @Test
    public void testAuthentication() {
        // 1,构建SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(myRealm);

        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");//加密算法使用md5
        matcher.setHashIterations(1);//哈希次数
        myRealm.setCredentialsMatcher(matcher);


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


        // 退出登录
        subject.logout();
        System.out.println("认证结果：" + subject.isAuthenticated());

//        认证结果：true
//        认证结果：false
    }

}

