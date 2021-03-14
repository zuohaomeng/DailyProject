package com.meng.common.spring.async.bean;

import com.meng.common.spring.async.utils.OSUtils;

import java.util.UUID;

/**
 * 保存线程信息
 * @author ZuoHao
 * @date 2021/3/12
 */
public class ThreadInfo {

    private String id = UUID.randomUUID().toString();

    private long startTime = System.currentTimeMillis();

    /** 项目名称 */
    private String project;

    /** 服务器IP */
    private String serverIp;

    /** 线程池模块 */
    private String module;

    /** 异步类名 */
    private String asyncName;

    /** 异步方法名 */
    private String methodName;

    public ThreadInfo(String project, String module, String asyncName, String methodName) {
        this.project = project;
        this.serverIp = OSUtils.getServerIp();
        this.module = module;
        this.asyncName = asyncName;
        this.methodName = methodName;
    }

    public String getThreadName() {
        return String.format("thread-%s-%s-%s", module, asyncName, methodName);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getAsyncName() {
        return asyncName;
    }

    public void setAsyncName(String asyncName) {
        this.asyncName = asyncName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
