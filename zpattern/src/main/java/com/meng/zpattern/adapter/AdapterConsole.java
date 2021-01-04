package com.meng.zpattern.adapter;

/**
 * @author ZuoHao
 * @date 2021/1/4
 */
public class AdapterConsole {
    public static void main(String[] args) {
        AC220 ac220 = new AC220();
        DC5 dc5 = new PowerAdapter(ac220);
        System.out.println("输出电压为："+dc5.outputDC5V());
    }
}
