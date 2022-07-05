package com.meng.arithmetic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZuoHao
 * @date 2022/3/1
 */
public class ProducerConsumer {
    private static final int MAX_LEN = 10;
    private static Queue<Integer> queue = new LinkedList<Integer>();
    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            while (true) {
                synchronized (queue) {
                    if (queue.size() == MAX_LEN) {//如果满了就阻塞
                        try {
                            queue.wait();
                            System.out.println("当前队列满");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int value = atomicInteger.incrementAndGet();
                    queue.add(value);
                    System.out.println("生成了一个" + value);
                    queue.notifyAll();
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread consumer = new Thread(() -> {
            while (true) {
                synchronized (queue) {
                    if (queue.size() == 0) {//如果没了就阻塞
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("消费了" + queue.poll());
                    queue.notifyAll();
                }
            }
        });
        producer.start();
        consumer.start();
    }


}
