package com.meng.daily.javabase.thread;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ZuoHao
 * @date 2021/5/5
 */
public class ThreadWaitDemo extends Thread{
    private static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println("lock");
            TimeUnit.MINUTES.sleep(10);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new ThreadWaitDemo();
        Thread t2 = new ThreadWaitDemo();
        t1.start();
        t2.start();
        t2.interrupt();
        Condition condition = new ReentrantLock().newCondition();
    }
}
