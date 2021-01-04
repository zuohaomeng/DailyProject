package com.meng.zpattern.delegate;

/**
 * @author ZuoHao
 * @date 2021/1/3
 */
public class DelegateConsole {
    public static void main(String[] args) {
        Boss bigBoss = new Boss();
        bigBoss.command("散打",new Leader());
    }
}
