package com.uncley.mystarteruse;

import com.uncley.AbstractMyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author uncleY
 * @date 2019/8/5 14:37
 */

@Component
@Slf4j
public class MyStarterUseTest implements CommandLineRunner {
    @Autowired
    private AbstractMyService myService;

    @Override
    public void run(String... args) throws Exception {
      log.info(myService.hello());
    }
}
