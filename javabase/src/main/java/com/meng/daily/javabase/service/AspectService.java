package com.meng.daily.javabase.service;

/**
 * @author ZuoHao
 * @date 2021/1/20
 */
public interface AspectService {
    /**
     * 方法正确返回
     */
    void successReturn();

    /**
     * 抛出异常
     */
    void returnException();
}
