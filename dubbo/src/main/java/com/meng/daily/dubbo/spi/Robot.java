package com.meng.daily.dubbo.spi;

import org.apache.dubbo.common.extension.SPI;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020/9/3 11:01
 */
@SPI
public interface Robot {
    void sayHello();
}
