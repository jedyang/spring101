package com.uncley;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 使用抽象类
 * 演示，多版本选择
 * 和 客户端实现以覆盖
 */
public abstract class AbstractMyService {

    protected String word;
    public AbstractMyService(String word) {
        this.word = word;
    }

    public AbstractMyService() {
        this ("Hello");
    }

    @Autowired
    protected MyServiceProperties properties;

    public abstract String hello();
}
