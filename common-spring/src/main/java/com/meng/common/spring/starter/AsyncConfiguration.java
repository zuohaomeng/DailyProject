package com.meng.common.spring.starter;

import com.meng.common.spring.async.config.AsyncConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZuoHao
 * @date 2021/3/13
 */
@Configuration
@ComponentScan("com.meng.common.spring.async")
@EnableConfigurationProperties(AsyncProperties.class)
public class AsyncConfiguration {

    @Autowired
    private AsyncProperties asyncProperties;

    @Bean
    @ConditionalOnMissingBean
    public AsyncConfig asyncConfig() {
        AsyncConfig asyncConfig = new AsyncConfig();
        asyncConfig.setProjectName(asyncProperties.getProjectName());
        asyncConfig.setExecutor(asyncProperties.getExecutor());
        return asyncConfig;
    }
}
