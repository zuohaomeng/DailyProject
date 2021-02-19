package com.meng.daily.javabase;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZuoHao
 * @date 2021/1/14
 */
public class MainConsole {
    public volatile static boolean stop = false;
    public static void main(String[] args) throws InterruptedException {
        String str = "10102000|12312|21312";
        String[] split = str.split("\\|");
        List<Integer> workCityList = Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
        workCityList.stream().forEach(System.out::println);
    }
}
