package com.meng.daily.dubbo.spi;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020/9/3 11:02
 */
public class OptimusPrime implements Robot {

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Optimus Prime");
    }
}
