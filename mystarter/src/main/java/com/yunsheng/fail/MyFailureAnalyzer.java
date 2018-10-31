package com.yunsheng.fail;

import com.yunsheng.AbstractMyService;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

public class MyFailureAnalyzer extends AbstractFailureAnalyzer<NoSuchBeanDefinitionException> {
    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, NoSuchBeanDefinitionException cause) {
        if(cause.getBeanType().equals(AbstractMyService.class)){
            return new FailureAnalysis("加载MyService失败", "请检查配置文件中的version属性设置是否是v1或v2", rootFailure);
        }

        return null;
    }
}
