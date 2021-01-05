package com.meng.zpattern.decorator.v1;

/**
 * @author ZuoHao
 * @date 2021/1/4
 */
public class BattercakeWithEggAndSausage extends BattercateWithEgg {
    @Override
    public String getMsg() {
        return super.getMsg() + "加香肠";
    }

    @Override
    public int price() {
        return super.price() + 2;
    }
}
