package com.meng.zpattern.decorator.v2;

/**
 * @author ZuoHao
 * @date 2021/1/4
 */
public class DecoratorConsole {
    public static void main(String[] args) {
        //首先是一个基础的煎饼
        Battercake battercake = new BaseBatterCake();

        //加了鸡蛋的煎饼
        battercake = new EggDecorator(battercake);
        System.out.println(battercake.getMsg());

        //再次加鸡蛋
        battercake = new EggDecorator(battercake);
        System.out.println(battercake.getMsg());

        //加烤肠
        battercake = new SausageDecorator(battercake);
        System.out.println(battercake.getMsg());


    }
}
