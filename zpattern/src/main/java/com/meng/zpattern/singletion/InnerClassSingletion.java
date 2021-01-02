package com.meng.zpattern.singletion;

/**
 * 静态内部类单例模式
 * @author ZuoHao
 * @date 2021/1/2
 */
public class InnerClassSingletion {
    private InnerClassSingletion(){}

    private static class InnerClassHolder{
        private static final InnerClassSingletion INSTANCE_HOLDER = new InnerClassSingletion();
    }

    public static InnerClassSingletion getInstance(){
        return InnerClassHolder.INSTANCE_HOLDER;
    }
}
