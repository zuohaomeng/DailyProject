package com.meng.common.spring.async.common;

import com.meng.common.spring.async.bean.ThreadInfo;

import java.util.concurrent.Callable;

/**
 * @author ZuoHao
 * @date 2021/3/12
 */
public abstract class ICallable<T> implements Callable<T> {
    private ThreadInfo threadInfo;

    public ICallable(ThreadInfo threadInfo) {
        this.threadInfo = threadInfo;
    }

    public abstract void ienter();

    public abstract T icall() throws Exception;

    public abstract void iexst() throws Exception;

    @Override
    public T call() throws Exception {
        try {
            Thread.currentThread().setName(threadInfo.getThreadName());
            ienter();
            return icall();
        } finally {
            iexst();
        }
    }

    public ThreadInfo getThreadInfo() {
        return threadInfo;
    }
}
