package com.meng.feature.menu;


import com.meng.feature.bean.User;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020/9/5 19:51
 */
public class StreamTest {
    public static void main(String[] args) {
        split();
    }


    public static void split() {
        List<String> list = Arrays.asList("hello", "key");
        List<String> collect = list.stream()
                .map(e -> {
                    System.out.println(e);
                    return e.split("");
                })
                .flatMap(e->{
                    System.out.println(Arrays.toString(e));
                    return Arrays.stream(e);
                })
                .filter(e->{
                    System.out.println(e);
                    return true;
                })
                .distinct()
                .collect(toList());
    }

    public static void foreach() {
        List<String> list = Arrays.asList("hello", "key");
        list.stream()
                .filter(e -> {
                    System.out.println(e);
                    return true;
                })
                .map(e -> {
                    System.out.println(e);
                    return e;
                }).collect(Collectors.toList());
    }
}
