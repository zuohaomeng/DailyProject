package com.meng.daily.javabase.proxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * @Description 动态代理控制器
 * @Author ZuoHao
 * @Date 2020/8/31 16:20
 */
public class ProxyConsole {
    public static void main(String[] args) {
//        JDKProxy();
        CglibProxy();

    }

    /**
     * cglib动态代理
     */
    private static void CglibProxy() {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./proxy");
        Enhancer enhancer = new Enhancer();
        //继承被代理类
        enhancer.setSuperclass(Animal.class);
        //设置回调
        enhancer.setCallback(new MyMethodInterceptor());
        //设置代理类对象
        Animal helloService = (Animal) enhancer.create();
        //在调用代理类中方法时会被我们实现的方法拦截器进行拦截
        helloService.sleep();
    }

    /**
     * jdk动态代理
     */
    public static void JDKProxy(){
        // 保存生成的代理类的字节码文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        SimpleInterface simpleInterface = new SimpleInterfaceImpl();
        SimpleInterface proxy = new JDKSimpleInvocationHandlerImpl(simpleInterface).getProxy();

        proxy.sayHello();
    }
}
