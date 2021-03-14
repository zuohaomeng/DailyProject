package com.meng.common.spring.async.common;

import com.meng.common.spring.async.bean.ThreadInfo;

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

    /**
     * 刷新当前活跃线程数据
     */
    public void freshThreadInfo() {
        threadInfo.setId(UUID.randomUUID().toString());
        threadInfo.setStartTime(System.currentTimeMillis());
    }
}