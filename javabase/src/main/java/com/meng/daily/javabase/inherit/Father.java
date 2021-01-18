package com.meng.daily.javabase.inherit;

/**
 * @author ZuoHao
 * @date 2021/1/18
 */
public class Father {

    public void say(){
        System.out.println("father public say");
        make();
        staticMake();
        tell();

    }
    public void make(){
        System.out.println("father public make");
    }

    public static void staticMake(){
        System.out.println("father public static make");
    }
    private void tell(){
        System.out.println("father private tell");
    }
}
