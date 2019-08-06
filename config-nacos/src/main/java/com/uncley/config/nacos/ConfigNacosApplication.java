package com.uncley.config.nacos;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 配置groupID，默认是default
@NacosPropertySource(dataId = "ns", autoRefreshed = true, groupId = "NEW_GROUP")
//@NacosPropertySource(dataId = "ns", autoRefreshed = true)
public class ConfigNacosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigNacosApplication.class, args);
	}

}
