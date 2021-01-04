package com.meng.zpattern.proxy.jdkproxy;


import com.meng.zpattern.proxy.staticproxy.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代购
 * @author ZuoHao
 * @date 2021/1/2
 */
public class BuyAgent implements  InvocationHandler {
    //目标类
    private Person target;

    public Object getInstance(Person person) throws Exception{
        this.target = person;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    /**
     *
     * @param proxy 字节码生成的代理类
     * @param method 调用方法
     * @param args  参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代购增强买书行为");
        System.out.println(proxy.getClass());
        //调用目标类的方法
        return method.invoke(target,args);
    }
}
