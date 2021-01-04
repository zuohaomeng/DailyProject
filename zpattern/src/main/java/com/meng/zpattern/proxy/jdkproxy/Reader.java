package com.meng.zpattern.proxy.jdkproxy;

import com.meng.zpattern.proxy.staticproxy.Person;

/**
 * 读者
 * @author ZuoHao
 * @date 2021/1/2
 */
public class Reader implements Person {
    @Override
    public void buyBook() {
        System.out.println("买书");
    }
}
