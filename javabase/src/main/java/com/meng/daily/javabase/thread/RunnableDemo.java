package com.meng.daily.javabase.thread;

/**
 * @author ZuoHao
 * @date 2021/5/5
 */
public class RunnableDemo implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"\t"+RunnableDemo.class);
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableDemo());
        thread.start();
    }
}
