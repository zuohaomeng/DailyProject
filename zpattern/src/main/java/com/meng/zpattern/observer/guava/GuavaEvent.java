package com.meng.zpattern.observer.guava;

import com.google.common.eventbus.Subscribe;

/**
 * @author ZuoHao
 * @date 2021/1/5
 */
public class GuavaEvent {
    @Subscribe
    public void subscribe(StringBuffer str){
        System.out.println("执行subscribe方法，传入的参数是：" + str.toString());
    }
}
