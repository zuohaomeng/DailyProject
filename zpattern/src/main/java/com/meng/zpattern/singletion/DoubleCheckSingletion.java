package com.meng.zpattern.singletion;


/**
 * 双重校验单例模式
 * @author ZuoHao
 * @date 2021/1/2
 */
public class DoubleCheckSingletion {
    private static volatile DoubleCheckSingletion instance = null;
    private DoubleCheckSingletion(){

    }

    public static DoubleCheckSingletion getInstance(){
        if(instance == null){
            synchronized (DoubleCheckSingletion.class){
                if(instance == null){
                    instance = new DoubleCheckSingletion();
                    //1。分配内存空间
                    //2。初始化对象
                    //3。将对象引用赋值给变量
                }
            }
        }
        return instance;
    }
}
