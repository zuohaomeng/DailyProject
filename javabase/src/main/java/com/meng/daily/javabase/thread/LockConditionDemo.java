package com.meng.daily.javabase.thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ZuoHao
 * @date 2021/5/6
 */
public class LockConditionDemo {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            lock.lock();
            try {
                System.out.println("lock await");
                condition.await();
                TimeUnit.MINUTES.sleep(10);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });
        Thread t2 = new Thread(()->{
            lock.lock();
            try {
                condition.signal();
                System.out.println("lock signal");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        t2.start();
    }
}
