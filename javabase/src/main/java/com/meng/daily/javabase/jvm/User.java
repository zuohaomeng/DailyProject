package com.meng.daily.javabase.jvm;

import java.util.Date;

/**
 * @author ZuoHao
 * @date 2021/9/21
 */
public class User {
    private int age;
    private String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public static void main(String[] args) {
        System.out.println(new Date(1593130046000L));
    }
}
