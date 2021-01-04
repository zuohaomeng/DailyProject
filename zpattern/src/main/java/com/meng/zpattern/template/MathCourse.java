package com.meng.zpattern.template;

/**
 * 数学课
 *
 * @author ZuoHao
 * @date 2021/1/3
 */
public class MathCourse extends NetWorkCourse {
    private boolean needHomeworkFlag = false;

    public MathCourse(boolean needHomeworkFlag) {
        this.needHomeworkFlag = needHomeworkFlag;
    }

    @Override
    void checkHomework() {
        System.out.println("自己根据答案检查题目");
    }

    @Override
    protected boolean needHomework() {
        return this.needHomeworkFlag;
    }
}
