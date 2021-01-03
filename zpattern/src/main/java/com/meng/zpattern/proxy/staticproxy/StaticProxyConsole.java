package com.meng.zpattern.proxy.staticproxy;

/**
 * @author ZuoHao
 * @date 2021/1/2
 */
public class StaticProxyConsole {
    public static void main(String[] args) {
        //静态代理
        Father father = new Father(new Son());
        father.buyBook();
    }
}
