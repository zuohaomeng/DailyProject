package com.meng.common.spring.async.enable;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author ZuoHao
 * @date 2021/3/14
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({CommonAsyncSelect.class})
public @interface EnableCommonAsync {

}
