package com.meng.daily.javabase.proxy.cglib;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020/8/31 16:46
 */
public class MyMethodInterceptor implements MethodInterceptor {
    /**
     * @param o           代理对象
     * @param method      目标类中的方法
     * @param objects     方法参数
     * @param methodProxy 代理方法的MethodProxy对象
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(">>>>>>>>>>>>>>>start<<<<<<<<<<<<");

        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println(">>>>>>>>>>>>>>>end<<<<<<<<<<<<");

        return result;
    }
}
