package com.meng.zpattern.singletion;

/**
 * 饿汉单例模式
 * @author ZuoHao
 * @date 2021/1/2
 */
public class HungrySingletion {
    //不要忘记加上 static final
    //类加载的时候就创建
    //final不允许反射时被修改
    //缺点：浪费内存，可以小范围使用这个
    private static final HungrySingletion hungrySingletion = new HungrySingletion();
    private HungrySingletion(){
    }

    public HungrySingletion getHungrySingletion() {
        return hungrySingletion;
    }
}
