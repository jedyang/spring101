package com.yunsheng;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyStarterServiceV1 extends AbstractMyService{

    public MyStarterServiceV1(String word) {
        super(word);
        log.info("MyStarterServiceV1:可以在构造器里执行点什么");
    }

    public MyStarterServiceV1(){}

    @Override
    public String hello() {
        return String.format("V1 %s >> %s:%s !!", word, properties.getName(), properties.getAge());
    }

}
