package com.meng.daily.javabase.test;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020/10/23 10:19
 */
public class Console {
    private static int i = 0;
    public static void main(String[] args) throws InterruptedException {
        System.out.println("https://photo.zastatic.com/review/photo/280032/1120128980/77674338314095679.jpg".length());
        Thread thread = new Thread((()->{
            while (!Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println(i);
            System.out.println(Thread.currentThread().isInterrupted());
        }));
        thread.start();
        TimeUnit.MILLISECONDS.sleep(10);
        thread.interrupt();
    }
}
