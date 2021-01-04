package com.meng.feature.menu;

import com.meng.feature.bean.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020/9/2 20:29
 */
public class FilteringApples {
    static List<Apple> inventory = Arrays.asList(
            new Apple(80, "green"),
            new Apple(155, "green"),
            new Apple(120, "red")
    );

    public static void main(String[] args) {
        //以前的写法
        System.out.println(">>>>>>>>>>>>>>>>>以前的写法<<<<<<<<<<<<<<<<<<<");
        List<Apple> appleList = filterGreenApples();
        appleList.stream().forEach(System.out::println);

        System.out.println(">>>>>>>>>>>>>>>>>函数传递写法<<<<<<<<<<<<<<<<<<<");
        List<Apple> appleList1 = filterApple(inventory, Apple::isGreen);
        List<Apple> appleList2 = filterApple(inventory, (Apple a) -> "green".equals(a.getColor()));
        appleList1.stream().forEach(System.out::println);
        appleList2.stream().forEach(System.out::println);

        System.out.println(">>>>>>>>>>>>>>>>>stream的写法<<<<<<<<<<<<<<<<<<<");
        inventory.stream()
                .filter(e -> "green".equals(e.getColor()))
                .forEach(System.out::println);

    }

    public static List<Apple> filterGreenApples() {
        List<Apple> list = new ArrayList<>();
        for (Apple a : inventory) {
            if ("green".equals(a.getColor())) {
                list.add(a);
            }
        }
        return list;
    }


    public static List<Apple> filterApple(List<Apple> apples, Predicate<Apple> p) {
        List<Apple> appleList = new ArrayList<>();
        for (Apple apple : apples) {
            if (p.test(apple)) {
                appleList.add(apple);
            }
        }
        return appleList;
    }

    /**
     * 相比于stream够更优秀的写法
     * 优点：适用于所有的List。不只是Apple这个类。
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }
}
