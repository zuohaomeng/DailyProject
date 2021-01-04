package com.meng.zpattern.proxy.staticproxy;

/**
 * @author ZuoHao
 * @date 2021/1/2
 */
public class Son implements Person{
    @Override
    public void buyBook() {
        System.out.println("买书");
    }
}
