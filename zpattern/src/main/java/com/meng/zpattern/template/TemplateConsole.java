package com.meng.zpattern.template;

/**
 * @author ZuoHao
 * @date 2021/1/3
 */
public class TemplateConsole {
    public static void main(String[] args) {
        System.out.println("-----腾讯网课开始了");
        NetWorkCourse mathCourse = new MathCourse(true);
        mathCourse.createCourse();
    }
}
