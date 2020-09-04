package com.meng.daily.dubbo.spi;

import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020/9/3 11:03
 */
public class Console {
    public static void main(String[] args) {
        ExtensionLoader<Robot> extensionLoader =
                ExtensionLoader.getExtensionLoader(Robot.class);
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();
        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
    }
}
