package com.meng.start;

import com.meng.common.spring.pattern.strategy.StrategyFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZuoHao
 * @date 2021/4/28
 */
@Configuration
public class StrategyConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public StrategyFactory strategyFactory() {
        return new StrategyFactory();
    }
}
