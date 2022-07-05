package com.meng.arithmetic;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程打印ABC
 * @author ZuoHao
 * @date 2022/3/1
 */
public class ThreadPrintfABC {
    private static AtomicLong aLong = new AtomicLong(0);
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();

        Thread t1 = new Thread(()->{
            while (aLong.get()<100) {
                try {
                    lock.lock();
                    long value = aLong.get();
                    if(value % 3 == 0){
                        System.out.println("A");
                        aLong.incrementAndGet();
                        c2.signal();
                    }else {
                        c1.await();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread t2 = new Thread(()->{
            while (aLong.get()<100) {
                try {
                    lock.lock();
                    long value = aLong.get();
                    if(value % 3 == 1){
                        System.out.println("B");
                        aLong.incrementAndGet();
                        c3.signal();
                    }else {
                        c2.await();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread t3 = new Thread(()->{
            while (aLong.get()<100) {
                try {
                    lock.lock();
                    long value = aLong.get();
                    if(value % 3 == 2){
                        System.out.println("C");
                        aLong.incrementAndGet();
                        c1.signal();
                    }else {
                        c3.await();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        t1.start();
//        t2.start();
//        t3.start();
    }
}
