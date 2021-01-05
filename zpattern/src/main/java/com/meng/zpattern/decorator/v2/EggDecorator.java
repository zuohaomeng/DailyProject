package com.meng.zpattern.decorator.v2;

/**
 * @author ZuoHao
 * @date 2021/1/4
 */
public class EggDecorator extends BattercakeDecorator {
    public EggDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    public String getMsg() {
        return super.getMsg() + "加鸡蛋";
    }

    @Override
    public int price() {
        return super.price() + 2;
    }
}
