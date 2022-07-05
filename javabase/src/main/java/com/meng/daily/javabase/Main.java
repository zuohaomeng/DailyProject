package com.meng.daily.javabase;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;


/**
 * @author ZuoHao
 * @date 2021/9/13
 */
public class Main {
    private int i = 1;
    private String a = "1";

    public static void main(String[] args) throws InterruptedException {
        System.out.println("123123".substring(1,3));
        LocalDateTime localDateTime = LocalDateTime.of(2019,10,10,20,10);
        System.out.println(localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli());
    }


}
