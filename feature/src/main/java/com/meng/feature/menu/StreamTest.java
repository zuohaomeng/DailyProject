package com.meng.feature.menu;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020/9/5 19:51
 */
public class StreamTest {
    static List<String> stringList = new ArrayList<>();
    static {
        stringList.add("apple");
        stringList.add("pear");
        stringList.add("orange");
        stringList.add("banana");
    }
    public static void main(String[] args) {
        //通知使用了哪些但是
//        split();
        //flatMap()
//        flatMap();
        //查找和匹配
        reduce();
    }


    public static void split() {
        List<String> list = Arrays.asList("hello", "key");
        List<String> collect = list.stream()
                .map(e -> {
                    System.out.println(e);
                    return e.split("");
                })
                .flatMap(e -> {
                    System.out.println(Arrays.toString(e));
                    return Arrays.stream(e);
                })
                .filter(e -> {
                    System.out.println(e);
                    return true;
                })
                .distinct()
                .collect(toList());
    }

    /**
     * 每个数的平方
     */
    public static void power2() {
        List<Integer> nums = Stream.iterate(1, x -> x + 1).limit(5).collect(toList());
    }

    /**
     * flatMap使用
     */
    public static void flatMap() {
        System.out.println(">>>>>>>>>>>>>>>>组合对<<<<<<<<<<<<<<<<<");
        //组合
        List<Integer> number1 = Arrays.asList(1, 2, 3);
        List<Integer> number2 = Arrays.asList(3, 4);
        number1.stream()
                .flatMap(i -> {
                    return number2.stream()
                            .map(j -> new int[]{i, j});
                }).forEach(e -> {
            System.out.println(Arrays.toString(e));
        });
        System.out.println(">>>>>>>>>>>>>>>>总和能被3整除<<<<<<<<<<<<<<<<<");
        number1.stream()
                .flatMap(i -> {
                    return number2.stream()
                            .map(j -> new int[]{i, j});
                }).filter(e -> (e[0] + e[1]) % 3 == 0)
                .forEach(e->{
                    System.out.println(Arrays.toString(e));
                });
    }
    /**
     * 查找和匹配
     */
    public static void match(){
        System.out.println(stringList.stream().allMatch(e->"apple".equals(e)));
        System.out.println(stringList.stream().anyMatch(e->"apple".equals(e)));
        System.out.println(stringList.stream().noneMatch(e->"apple1".equals(e)));
        Optional<String> first = stringList.stream().findFirst();
        Optional<String> any = stringList.stream().findAny();
        System.out.println(first.get());
        System.out.println(any.get());
    }

    /**
     * 归约
     */
    public static void reduce(){
        //求和
        List<Integer> nums = Arrays.asList(4,5,3,9);
        System.out.println(nums.stream().reduce(0, (a, b) -> a + b));
        //最大值和最小值
        System.out.println(nums.parallelStream().reduce((a,b)->Math.min(a,b)).get());
        System.out.println(nums.parallelStream().reduce((a,b)->Math.max(a,b)).get());
        System.out.println(nums.parallelStream().reduce(Integer::max).get());
    }


}
