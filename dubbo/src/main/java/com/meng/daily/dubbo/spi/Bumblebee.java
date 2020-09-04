package com.meng.daily.dubbo.spi;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020/9/3 11:02
 */
public class Bumblebee implements Robot {
    @Override
    public void sayHello() {
        System.out.println("Hello,I am Bumblebee.");
    }
}
