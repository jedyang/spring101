package com.uncley;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableConfigurationProperties(MyServiceProperties.class)
@Slf4j
public class MyAutoConfiguration {
    @Bean
    // ConditionalOnMissingBean：当客户端没有自己实现的service时，使用默认实现
    @ConditionalOnMissingBean(MyStarterServiceV1.class)
    // 使用的控制条件
//    matchIfMissing = true,则表示即使配置文件中没有定义该属性配置，也会加载该方法
    @ConditionalOnProperty(prefix = "spring101", name = "version", havingValue = "v1", matchIfMissing = true)
    MyStarterServiceV1 getMyService(){
        return new MyStarterServiceV1("hello");
    }

    @Bean
    @ConditionalOnMissingBean(MyStarterServiceV2.class)
    @ConditionalOnProperty(prefix = "spring101", name = "version", havingValue = "v2")
    MyStarterServiceV2 getMyV2Service(){
        return new MyStarterServiceV2("hello");
    }
}
