package com.meng.daily.javabase.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author ZuoHao
 * @date 2021/5/5
 */
public class ThreadClassDemo extends Thread{
    private static Object lock = new Object();
    @Override
    public void run() {
        synchronized (lock){
            System.out.println(Thread.currentThread().getName()+"\t"+ThreadClassDemo.class);
            while (true){
                if(Thread.interrupted()){
                    return;
                }
            }
//            try {
//                TimeUnit.MINUTES.sleep(10);
//            } catch (InterruptedException e) {
//
//                e.printStackTrace();
//            }
        }
    }
    public static void main(String[] args) {
        Thread t1 = new ThreadClassDemo();
        Thread t2 = new ThreadClassDemo();
        t1.start();
//        t2.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
    }
}
