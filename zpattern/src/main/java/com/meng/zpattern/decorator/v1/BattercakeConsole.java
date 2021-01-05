package com.meng.zpattern.decorator.v1;

/**
 * @author ZuoHao
 * @date 2021/1/4
 */
public class BattercakeConsole {

    public static void main(String[] args) {
        Battercake battercake = new Battercake();
        System.out.println(battercake.getMsg());
        System.out.println(battercake.price());
    }
}
