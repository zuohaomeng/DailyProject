package com.meng.me;

/**
 * @author ZuoHao
 * @date 2021/7/7
 */
public class Money {
    public static void main(String[] args) {
        System.out.println(3225+60579+44695);
        System.out.println(46000-41315);
//        sumOfMonth();
    }

    private static void sumOfMonth() {
        double sum = 0;
        double num = 1;
        int mouth = 3;
        //每月倍数
        double monthMultiple = 1.2;
        for (int i = 1; i <= mouth; i++) {
            num = num * monthMultiple;
        }
        System.out.println("n年总倍数：" + num);
        System.out.println("收益百分数：" + String.format("%.2f", (num - 1) * 100) + "%");
        for (int i = 1; i <= mouth; i++) {
            sum = (sum + 1) * monthMultiple;
        }
        double yield = ((sum / mouth) - 1) * 100;
        System.out.println("定投的收益率：" + String.format("%.2f", yield) + "%" );
        System.out.println("n年后总收入：" + sum);
    }

    private static void sumOfYear(){
        int year = 3;
        double sumMultiple = 1;
        double multiple = 1.2;
        for (int i = 1; i <= year; i++) {
            sumMultiple= sumMultiple * multiple;
        }
        System.out.println(sumMultiple);
    }
}
