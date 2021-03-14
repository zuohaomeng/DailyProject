package com.meng.common.spring.starter;

import com.meng.common.spring.async.config.PoolParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 线程池自动装配starter
 * @author ZuoHao
 * @date 2021/3/13
 */
@Component
@ConfigurationProperties(prefix = "async")
public class AsyncProperties {

    @Value("${async.project.name}")
    private String projectName;

    public Map<String, PoolParam> executor = new LinkedHashMap<>();

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Map<String, PoolParam> getExecutor() {
        return executor;
    }

    public void setExecutor(Map<String, PoolParam> executor) {
        this.executor = executor;
    }


}

