package com.meng.zpattern.observer.guava;

import com.google.common.eventbus.EventBus;

/**
 * @author ZuoHao
 * @date 2021/1/5
 */
public class GuavaEventConsole {
    public static void main(String[] args) {
        //消息总线
        EventBus eventBus = new EventBus();
        //事件处理类
        GuavaEvent guavaEvent = new GuavaEvent();
        //注册事件
        eventBus.register(guavaEvent);
        //通知事件
        eventBus.post(new StringBuffer("guava"));
    }
}
