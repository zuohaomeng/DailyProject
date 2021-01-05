package com.meng.zpattern.decorator.v1;

/**
 * 煎饼+鸡蛋
 * @author ZuoHao
 * @date 2021/1/4
 */
public class BattercateWithEgg extends Battercake {
    @Override
    public String getMsg() {
        return super.getMsg() + "加鸡蛋";
    }

    @Override
    public int price() {
        return super.price() + 2;
    }
}
