package com.meng.zpattern.observer.events;

/**
 * @author ZuoHao
 * @date 2021/1/5
 */
public class MouseEventConsole {
    public static void main(String[] args) {
        MouseEventCallback callback = new MouseEventCallback();

        Mouse mouse = new Mouse();

        //注册有哪些事件
        mouse.addLisenter(MouseEventType.ON_CLICK,callback);
        mouse.addLisenter(MouseEventType.ON_FOCUS,callback);


        //进行了点击
        mouse.click();
        //移动了鼠标
        mouse.focus();

    }
}
