package com.meng.daily.javabase.inherit;

/**
 * @author ZuoHao
 * @date 2021/1/18
 */
public class Son extends Father{
    @Override
    public void make(){
        System.out.println("son public make");
    }


    public static void staticMake(){
        System.out.println("son public static make");
    }
}
