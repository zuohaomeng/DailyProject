package com.meng.common.spring.async.annotation;

import java.lang.annotation.*;

/**
 * 异步任务注解
 * 有此注解的类的方法调用会异步调用
 * @author ZuoHao
 * @date 2021/3/11
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface AsyncTask {
    /**
     * 模块名称
     * @return
     */
    String value();
}
