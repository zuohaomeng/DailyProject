package com.meng.zpattern.proxy.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib代购人
 * @author ZuoHao
 * @date 2021/1/3
 */
public class CglibBuyAgent implements MethodInterceptor {
    private CglibReader reader;

    public Object getInstance(Class<?> clazz){
        //相当于Proxy，代理的工具类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /**
     *
     * @param o   字节码生成的代理类对象
     * @param method
     * @param objects 方法参数
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("读书增强了");
        System.out.println("o："+o.getClass());
        System.out.println("method： "+method.getClass()+"\t"+method.getName());
        System.out.println("methodProxy："+methodProxy.getClass());

        //生成的是子类，去调用父类的逻辑
        return methodProxy.invokeSuper(o,objects);
    }
}
