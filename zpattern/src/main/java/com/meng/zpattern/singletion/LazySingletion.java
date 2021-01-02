package com.meng.zpattern.singletion;

/**
 * 懒汉单例模式
 * @author ZuoHao
 * @date 2021/1/2
 */
public class LazySingletion {
    private static  LazySingletion lazySingletion = null;
    private LazySingletion(){
    }

    public static LazySingletion getLazySingletion() {
        if(lazySingletion == null) {
            //这里会出现多线程问题
            lazySingletion = new LazySingletion();
        }
        return lazySingletion ;
    }
    //又忘记加static，保证静态使用
    public static synchronized LazySingletion getLazySingletionSync(){
        //加了同步锁，效率会降低，每次都需要判断锁的状态
        if (lazySingletion == null){
            lazySingletion = new LazySingletion();
        }
        return lazySingletion;
    }


}
