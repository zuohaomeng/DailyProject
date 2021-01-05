package com.meng.zpattern.decorator.v2;

/**
 * 煎饼包装类
 * @author ZuoHao
 * @date 2021/1/4
 */
public abstract class BattercakeDecorator extends Battercake{
    Battercake battercake;

    public BattercakeDecorator(Battercake battercake) {
        this.battercake = battercake;
    }

    @Override
    public String getMsg() {
        return battercake.getMsg();
    }

    @Override
    public int price() {
        return battercake.price();
    }
}
