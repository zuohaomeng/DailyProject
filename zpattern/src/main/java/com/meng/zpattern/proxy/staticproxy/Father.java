package com.meng.zpattern.proxy.staticproxy;

/**
 * @author ZuoHao
 * @date 2021/1/2
 */
public class Father implements Person{
    private Person son;

    public Father(Person son) {
        this.son = son;
    }

    @Override
    public void buyBook() {
        System.out.println("带儿子去书店");
        son.buyBook();
        System.out.println("付钱");
    }
}
