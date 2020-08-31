package com.meng.daily.javabase.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020/8/31 16:14
 */
public class JDKSimpleInvocationHandlerImpl implements InvocationHandler {

    private SimpleInterface target;

    public JDKSimpleInvocationHandlerImpl(SimpleInterface simpleInterface) {
        this.target = simpleInterface;
    }


    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }


    /**
     * 该方法负责集中处理动态代理类上的所有方法调用
     *
     * @param proxy  代理类实例
     * @param method 调用方法
     * @param args   参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(">>>>>>>>>>>>>>>>>start<<<<<<<<<<<<<");
        Object result = method.invoke(target, args);
        System.out.println(">>>>>>>>>>>>>>>>>end<<<<<<<<<<<<<");

        return result;
    }
}
