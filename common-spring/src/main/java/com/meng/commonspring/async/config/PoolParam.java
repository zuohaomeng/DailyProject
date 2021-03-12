package com.meng.commonspring.async.config;

/**
 * @author ZuoHao
 * @date 2021/3/12
 */
public class PoolParam {
    private int coreSize;
    private int queueSize;
    private long schedulePeriod;
    private long scheduleDelay;
    private int reportType;
    private String scheduleUnit;
    private int rejectType;

    public int getCoreSize() {
        return coreSize;
    }

    public void setCoreSize(int coreSize) {
        this.coreSize = coreSize;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }

    public long getSchedulePeriod() {
        return schedulePeriod;
    }

    public void setSchedulePeriod(long schedulePeriod) {
        this.schedulePeriod = schedulePeriod;
    }

    public long getScheduleDelay() {
        return scheduleDelay;
    }

    public void setScheduleDelay(long scheduleDelay) {
        this.scheduleDelay = scheduleDelay;
    }

    public String getScheduleUnit() {
        return scheduleUnit;
    }

    public void setScheduleUnit(String scheduleUnit) {
        this.scheduleUnit = scheduleUnit;
    }

    public int getReportType() {
        return reportType;
    }

    public void setReportType(int reportType) {
        this.reportType = reportType;
    }

    public int getRejectType() {
        return rejectType;
    }

    public void setRejectType(int rejectType) {
        this.rejectType = rejectType;
    }
}
