package com.meng.zpattern.adapter;

/**
 * @author ZuoHao
 * @date 2021/1/3
 */
public class PowerAdapter implements DC5 {

    private AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }
    @Override
    public int outputDC5V() {
        int input = ac220.output220();
        int output = input / 44;
        System.out.println("适用适配器进行电压降级");
        return output;
    }
}
