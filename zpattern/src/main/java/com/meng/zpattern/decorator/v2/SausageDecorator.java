package com.meng.zpattern.decorator.v2;

/**
 * @author ZuoHao
 * @date 2021/1/4
 */
public class SausageDecorator extends BattercakeDecorator {

    public SausageDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    public String getMsg() {
        return super.getMsg() + "加香肠";
    }

    @Override
    public int price() {
        return super.price() + 2;
    }
}
