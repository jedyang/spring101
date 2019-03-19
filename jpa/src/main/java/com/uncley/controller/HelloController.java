package com.uncley.controller;

import com.uncley.Uncle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @作者 uncleY
 * @时间 2019/3/17
 * @描述 演示配置项使用
 */
@RestController
public class HelloController {

    @Value("${spring101.name}")
    private String name;

    @Value("${spring101.age}")
    private int age;

    @Value("${spring101.content}")
    private String content;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(){
//        String result = "my name is " + name + ", and age is" + age;
        return content;
    }

    @Autowired
    private Uncle uncle;
    @RequestMapping(value = "/helloUncle", method = RequestMethod.GET)
    public String sayHelloUncle(){
        return uncle.toString();
    }
}
