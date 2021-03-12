package com.meng.commonspring.async.bean;

import java.util.concurrent.TimeUnit;

/**
 * 定时配置信息
 * @author ZuoHao
 * @date 2021/3/12
 */
public class ScheduleInfo {

    /** 执行周期 */
    private long period = 0;

    /** 延迟时间 */
    private long delay = 0;

    /** 时间单位 */
    private TimeUnit timeUnit = TimeUnit.MILLISECONDS;

    public ScheduleInfo() {
    }

    public ScheduleInfo(long period, long delay, TimeUnit timeUnit) {
        this.period = period;
        this.delay = delay;
        this.timeUnit = timeUnit;
    }

    public long getPeriod() {
        return period;
    }

    public void setPeriod(long period) {
        this.period = period;
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }
}
