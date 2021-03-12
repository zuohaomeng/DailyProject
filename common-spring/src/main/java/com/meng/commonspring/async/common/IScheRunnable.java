package com.meng.commonspring.async.common;

import com.meng.commonspring.async.bean.ThreadInfo;

import java.util.UUID;

/**
 * @author ZuoHao
 * @date 2021/3/12
 */
public abstract class IScheRunnable extends IRunnable {

    public IScheRunnable(ThreadInfo threadInfo) {
        super(threadInfo);
    }

    @Override
    public void run() {
        Thread.currentThread().setName(threadInfo.getThreadName());
        freshThreadInfo();
        super.run();
    }

    public void freshThreadInfo() {
        threadInfo.setId(UUID.randomUUID().toString());
        threadInfo.setStartTime(System.currentTimeMillis());
    }
}