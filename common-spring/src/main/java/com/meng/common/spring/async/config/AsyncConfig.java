package com.meng.common.spring.async.config;

import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ZuoHao
 * @date 2021/3/12
 */
@Component
public class AsyncConfig {
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
