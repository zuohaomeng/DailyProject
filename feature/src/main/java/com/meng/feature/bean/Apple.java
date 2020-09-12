package com.meng.feature.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 苹果类
 * @Author ZuoHao
 * @Date 2020/9/2 20:28
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Apple {
    private int weight = 0;
    private String color = "";


    public static boolean isGreen(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
