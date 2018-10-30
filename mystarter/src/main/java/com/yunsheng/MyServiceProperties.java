package com.yunsheng;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置文件配置类
 */
@ConfigurationProperties(prefix = "spring101")
@Data
public class MyServiceProperties {
    /**
     * user name
     */
    private String name;
    /**
     * user age *Should between 1 and 120
     */
    private Integer age;
    /**
     * determine the service version you want use
     */
    private String version;
}
