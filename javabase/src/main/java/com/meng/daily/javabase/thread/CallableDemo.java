package com.meng.daily.javabase.thread;

import java.util.concurrent.*;

/**
 * @author ZuoHao
 * @date 2021/5/5
 */
public class CallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("call");
        return "callable";
    }

    public static void main(String[] args) {
       demo2();
    }
    public static void demo1(){
        CallableDemo callableDemo = new CallableDemo();
        FutureTask<String> futureTask = new FutureTask<>(callableDemo);
        try {
            futureTask.run();
            String s = futureTask.get();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void demo2(){
        ExecutorService executorService = Executors.newFixedThreadPool(1, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"MyThread-------");
            }
        });
        Future<String> submit = executorService.submit(new CallableDemo());
        try {
            String s = submit.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("demo2");
        executorService.shutdown();
    }
}
