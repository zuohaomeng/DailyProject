package com.meng.common.spring.pattern.strategy;

/**
 * @author ZuoHao
 * @date 2021/4/28
 */
public abstract class AbstractStrategy<T> {
    /**
     * 判断是否支持
     *
     * @param t
     * @return
     */
    abstract boolean support(T t);

    /**
     * 执行相应的方法
     *
     * @param t
     */
    abstract void execute(T t);
}
