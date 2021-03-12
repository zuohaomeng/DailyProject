package com.meng.commonspring.async.common;

import com.meng.commonspring.async.bean.ThreadInfo;

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
            T result = icall();

            return result;
        } finally {
            iexst();
        }
    }

    public ThreadInfo getThreadInfo() {
        return threadInfo;
    }
}
