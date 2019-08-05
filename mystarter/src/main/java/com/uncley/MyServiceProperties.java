package com.uncley;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置文件配置类
 */
@ConfigurationProperties(prefix = "spring101")
@Data
public class MyServiceProperties {
    private String name;
    private Integer age;
    /**
     * determine the service version you want use
     */
    private String version;
}
