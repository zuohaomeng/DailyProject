package com.meng.common.spring.async.common;


import com.meng.common.spring.async.bean.ThreadInfo;


/**
 * @author ZuoHao
 * @date 2021/3/12
 */
public abstract class IRunnable implements Runnable{
    protected ThreadInfo threadInfo;

    public IRunnable(ThreadInfo threadInfo) {
        this.threadInfo = threadInfo;
    }

    public abstract void ienter();

    public abstract void irun();

    public abstract void iexst();

    @Override
    public void run() {
        try {
            Thread.currentThread().setName(threadInfo.getThreadName());
            ienter();
            irun();
        } finally {
            iexst();
        }
    }

    public ThreadInfo getThreadInfo() {
        return threadInfo;
    }
}
