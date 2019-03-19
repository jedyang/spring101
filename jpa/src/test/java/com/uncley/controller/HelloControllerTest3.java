package com.uncley.controller;

import com.uncley.DemoApplication;
import com.uncley.Uncle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * 演示测试controller 第3种方法
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@AutoConfigureMockMvc
public class HelloControllerTest3 {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void sayHello() throws Exception {
        ResultActions perform = mockMvc.perform(MockMvcRequestBuilders.get("/hello"));
        // 打印下结果看看
        System.out.println(perform.andReturn().getResponse().getContentAsString());
        perform.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("content name is uncley and age is 40"));
    }

}