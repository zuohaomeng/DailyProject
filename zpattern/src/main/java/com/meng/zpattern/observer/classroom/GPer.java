package com.meng.zpattern.observer.classroom;

import java.util.Observable;

/**
 *
 * jdk自带的观察者模式
 * @author ZuoHao
 * @date 2021/1/5
 */
public class GPer extends Observable {

    private String name = "Gper课堂";
    private static GPer gPer = null;

    public GPer() {
    }

    public static GPer getInstance(){
        if(gPer == null){
            gPer = new GPer();
        }
        return gPer;
    }
    public String getName() {
        return name;
    }

    public void publishQuestion(Question question){
        System.out.println(question.getUserName() + "在" + this.name + "上提交了一个问题。");
        setChanged();
        notifyObservers(question);
    }
}
