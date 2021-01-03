package com.meng.zpattern.proxy.jdkproxy;

import com.meng.zpattern.proxy.staticproxy.Person;

import java.lang.reflect.Method;

/**
 * @author ZuoHao
 * @date 2021/1/2
 */
public class JDKProxyConsole {
    public static void main(String[] args) throws Exception {
        Person buyAgent = (Person) new BuyAgent().getInstance(new Reader());
        Method method = buyAgent.getClass().getMethod("buyBook",null);
        method.invoke(buyAgent);
    }
}
