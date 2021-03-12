package com.meng.commonspring.async.executor;

import com.meng.commonspring.async.bean.ScheduleInfo;
import com.meng.commonspring.async.bean.ThreadInfo;
import com.meng.commonspring.async.common.ICallable;
import com.meng.commonspring.async.common.IRunnable;
import com.meng.commonspring.async.utils.OSUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author ZuoHao
 * @date 2021/3/12
 */
public class IExecutor {
    private final static Logger LOGGER = LoggerFactory.getLogger(IExecutor.class);

    /** 项目 */
    private String project;

    /** 服务器IP */
    private String serverIp;

    /** 线程池 */
    private String module;

    /** 线程池处理器 */
    private ExecutorService excutor;

    /** 定时配置 */
    private ScheduleInfo scheduleInfo;

    /** 活跃的线程Map */
    private Map<String, ThreadInfo> activeThreadMap = new ConcurrentHashMap<String, ThreadInfo>();

    public IExecutor(String project, String module, ExecutorService excutor, ScheduleInfo scheduleInfo) {
        this.project = project;
        this.serverIp = OSUtils.getServerIp();
        this.module = module;
        this.excutor = excutor;
        this.scheduleInfo = scheduleInfo;
    }

    public String getProject() {
        return project;
    }

    public String getServerIp() {
        return serverIp;
    }

    public String getModule() {
        return module;
    }

    public ExecutorService getExcutor() {
        return excutor;
    }

    public ScheduleInfo getScheduleInfo() {
        return scheduleInfo;
    }

    /**
     * 执行异步任务
     *
     * @param command
     */
    public void execute(IRunnable command) {
        this.submit(command);
    }

    /**
     * 执行异步任务
     *
     * @param task
     * @return
     */
    public Future<?> submit(IRunnable task) {

        if (this.isSchedule()) {
            return schedule(task);
        }

        try {
            Future<?> future = excutor.submit(task);
            return future;

        } catch (RejectedExecutionException e) {
            throw e;
        }
    }

    /**
     * 执行异步任务
     *
     * @param task
     * @return
     */
    public <T> Future<T> submit(ICallable<T> task) {

        try {
            Future<T> future = excutor.submit(task);
            return future;

        } catch (RejectedExecutionException e) {
            throw e;
        }
    }

    /**
     * 执行异步定时任务
     *
     * @param task
     * @return
     */
    public Future<?> schedule(IRunnable task) {

        try {
            if (excutor instanceof ScheduledExecutorService) {

                if (isDelayShedule()) {
                    return ((ScheduledExecutorService) excutor).schedule(task, scheduleInfo.getDelay(), scheduleInfo.getTimeUnit());
                }

                Future<?> future = ((ScheduledExecutorService) excutor).scheduleAtFixedRate(task, scheduleInfo.getDelay(), scheduleInfo.getPeriod(),
                        scheduleInfo.getTimeUnit());
                return future;
            } else {

                throw new RuntimeException("iexecutor schedule parse error, excutor = " + excutor);
            }

        } catch (RejectedExecutionException e) {
            throw e;
        }
    }

    /**
     * 添加一个线程
     */
    public void addThread(ThreadInfo threadInfo) {
        activeThreadMap.put(threadInfo.getId(), threadInfo);
    }

    /**
     * 线程结束移除
     */
    public void removeThread(String id) {
        activeThreadMap.remove(id);
    }

    /**
     * 获取所有活跃线程
     */
    public Collection<ThreadInfo> getActiveThreadInfos() {
        return activeThreadMap.values();
    }

    /**
     * 是否定时任务
     *
     * @return
     */
    public boolean isSchedule() {
        return isSchedule(scheduleInfo.getPeriod(), scheduleInfo.getDelay());
    }

    public static boolean isSchedule(long period, long delay) {
        return delay > 0 || period > 0;
    }

    private boolean isDelayShedule() {
        if (!isSchedule()) {
            return false;
        }
        return scheduleInfo.getPeriod() <= 0;
    }
}
