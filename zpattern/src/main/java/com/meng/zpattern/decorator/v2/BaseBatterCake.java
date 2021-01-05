package com.meng.zpattern.decorator.v2;

/**
 * @author ZuoHao
 * @date 2021/1/4
 */
public class BaseBatterCake extends Battercake{
    @Override
    public String getMsg(){
        return "煎饼";
    }


    @Override
    public int price(){
        return 5;
    }
}
