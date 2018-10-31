package com.yunsheng;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 创建一个V2版本 演示客户端根据自己的情况，选择执行不同版本的服务
 */
@Slf4j
public class MyStarterServiceV2 extends AbstractMyService {


    public MyStarterServiceV2(String word) {
        super(word);
        log.info("MyStarterServiceV2:可以在构造器里执行点什么");
    }

    public MyStarterServiceV2() {
    }

    @Override
    public String hello() {
        return String.format("V2 %s >> %s:%s !!", word, properties.getName(), properties.getAge());
    }

}
