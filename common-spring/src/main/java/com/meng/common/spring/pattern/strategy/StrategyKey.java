package com.meng.common.spring.pattern.strategy;

import java.lang.annotation.*;

/**
 * 策略模式key
 *
 * @author ZuoHao
 * @date 2021/4/28
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface StrategyKey {
    String value();
}
