package com.meng.zpattern.observer.classroom;

/**
 * @author ZuoHao
 * @date 2021/1/5
 */
public class ObserverConsole {
    public static void main(String[] args) {
        //1。老师开始上课了
        Question question = new Question("小明","什么时候放假");
        GPer gper = GPer.getInstance();
        Teacher tom = new Teacher("Tom");
        Teacher mic = new Teacher("Mic");
        gper.addObserver(tom);
        gper.addObserver(mic);
        gper.publishQuestion(question);
    }
}
