package com.meng.zpattern.singletion;

/**
 * 线程级别的单例模式
 * @author ZuoHao
 * @date 2021/1/2
 */
public class ThreadSingleton {
    //Object是需要保持单例的类，使用时替换
    private static final ThreadLocal<Object> instance = new ThreadLocal<Object>(){
        @Override
        protected Object initialValue() {
            return new Object();
        }
    };

    public static Object getInstance(){
        return instance.get();
    }

}
