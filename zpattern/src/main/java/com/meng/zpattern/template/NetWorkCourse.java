package com.meng.zpattern.template;

/**
 * 网课流程
 *
 * @author ZuoHao
 * @date 2021/1/3
 */
public abstract class NetWorkCourse {
    protected final void createCourse() {
        //1。发布预习资料
        postPreResource();

        //2.制作ppt
        createPPT();

        //3。在线直播
        liveVideo();

        //4。提交课件
        postNote();

        //5。布置作业
        if (needHomework()) {
            checkHomework();
        }
    }

    abstract void checkHomework();

    /**
     * 钩子方法
     * @return
     */
    protected boolean needHomework() {
        return false;
    }

    final void postNote() {
        System.out.println("提交笔记");
    }

    final void liveVideo() {
        System.out.println("直播授课");
    }

    final void createPPT() {
        System.out.println("创建ppt");
    }

    final void postPreResource() {
        System.out.println("分发预习资料");
    }
}
