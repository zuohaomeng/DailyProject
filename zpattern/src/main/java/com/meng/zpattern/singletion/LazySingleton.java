package com.meng.zpattern.singletion;

/**
 * 懒汉单例模式
 * @author ZuoHao
 * @date 2021/1/2
 */
public class LazySingleton {
    private static LazySingleton lazySingleton = null;
    private LazySingleton(){
    }

    public static LazySingleton getLazySingletion() {
        if(lazySingleton == null) {
            //这里会出现多线程问题
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
    //又忘记加static，保证静态使用
    public static synchronized LazySingleton getLazySingletionSync(){
        //加了同步锁，效率会降低，每次都需要判断锁的状态
        if (lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }


}
