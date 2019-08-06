package com.uncley.config.nacos;

import com.alibaba.nacos.api.config.annotation.NacosValue;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("config")
public class ConfigController {

    // uncley是默认值
    // 默认值是程序启动时，nacos还没配置会用这个
    // 如果已经从nacos获取到值，然后在nacos删除，
    // 这里不会变成默认值，仍然使用上次从nacos获取的值
    @NacosValue(value = "${name:uncley}", autoRefreshed = true)
    private String name;

    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public String get() {
        return name;
    }
}