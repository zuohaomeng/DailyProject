package com.meng.daily.javabase.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZuoHao
 * @date 2021/9/22
 */
public class Test {
    private static final List<DiscountSmsRecord> LIST = new ArrayList<>();
    public static void main(String[] args) {

        int[] a = new int[2];
        getObject(a);
        System.out.println(a.getClass());
    }
    public static void getObject(Object o){

    }
}
