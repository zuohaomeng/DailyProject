package com.meng.zpattern.singletion;

/**
 * 静态内部类单例模式
 *
 * @author ZuoHao
 * @date 2021/1/2
 */
public class InnerClassSingleton {
    private InnerClassSingleton() {
        if (InnerClassHolder.INSTANCE_HOLDER != null) {
            throw new RuntimeException("create InnerClassSingletion again");
        }
    }

    private static class InnerClassHolder {
        private static final InnerClassSingleton INSTANCE_HOLDER = new InnerClassSingleton();
    }

    //该方法没有执行的时候，不会调用InnerClassHolder初始化对象
    public static InnerClassSingleton getInstance() {
        return InnerClassHolder.INSTANCE_HOLDER;
    }


    public String name = "mengzuo";
}
