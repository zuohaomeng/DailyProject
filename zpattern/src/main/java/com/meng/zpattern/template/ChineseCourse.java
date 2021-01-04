package com.meng.zpattern.template;

/**
 * @author ZuoHao
 * @date 2021/1/3
 */
public class ChineseCourse extends NetWorkCourse {
    private boolean needHomeworkFlag = false;

    public ChineseCourse(boolean needHomeworkFlag) {
        this.needHomeworkFlag = needHomeworkFlag;
    }

    @Override
    void checkHomework() {
        System.out.println("不用检查");
    }

    @Override
    protected boolean needHomework() {
        return this.needHomeworkFlag;
    }
}
