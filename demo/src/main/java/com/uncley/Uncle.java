package com.uncley;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @作者 uncleY
 * @时间 2019/3/17
 * @描述
 */
@Component
@ConfigurationProperties(prefix = "spring101")
@Data
public class Uncle {
    private String name;
    private int age;
    private String content;
}
