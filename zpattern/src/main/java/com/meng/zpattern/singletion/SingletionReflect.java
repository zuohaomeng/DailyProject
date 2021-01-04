package com.meng.zpattern.singletion;

import java.lang.reflect.Constructor;

/**
 *
 * 单例反射破坏
 * @author ZuoHao
 * @date 2021/1/2
 */
public class SingletionReflect {
    public static void main(String[] args) {
        try {
            Class<?> clazz = InnerClassSingleton.class;
            Constructor c = clazz.getDeclaredConstructor(null);
            c.setAccessible(true);
            //反射获取
            InnerClassSingleton instance1 = (InnerClassSingleton)c.newInstance(null);
            //正常方法获取
            InnerClassSingleton instance2 = InnerClassSingleton.getInstance();

            System.out.println(instance1 == instance2);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
