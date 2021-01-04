package com.meng.zpattern.singletion;

/**
 * 饿汉单例模式
 * @author ZuoHao
 * @date 2021/1/2
 */
public class HungrySingleton {
    //不要忘记加上 static final
    //类加载的时候就创建
    //final不允许反射时被修改
    //缺点：浪费内存，可以小范围使用这个
    private static final HungrySingleton HUNGRY_SINGLETON = new HungrySingleton();
    private HungrySingleton(){
    }

    public static HungrySingleton getHungrySingletion() {
        return HUNGRY_SINGLETON;
    }



    //重写readResolve，只不过时覆盖了反序列化出来的对象。
    //对象还是创建了两次，只是反序列化的创建的对象会被GC，而返回readResolve()方法返回的对象。
    public Object readResolve(){
        return HUNGRY_SINGLETON;
    }
}
