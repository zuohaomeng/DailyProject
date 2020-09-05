package com.meng.feature.chap02;

import com.meng.feature.bean.Apple;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020/9/5 16:43
 */
public class LambdaFuncation {
    static Integer i = new Integer(1);
    public static void main(String[] args) {
        throwError();
    }
    public static void throwError()  {
        List list = Arrays.asList("a","b","c");

        list.stream()
                .forEach(e->{
                    i = new Integer(2);
                });
    }
    public static void fastCreateListObject(){
    }
}
