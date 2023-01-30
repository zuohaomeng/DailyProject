package com.meng.daily.javabase;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZuoHao
 * @date 2021/9/13
 */
public class Main {
    public static void main(String[] args) {

    }
    public boolean canJump(int[] nums) {
        int k = 0;
        for(int i = 0;i < nums.length;i++){
            if(k < i){
                return false;
            }
            k = Math.max(k,i+nums[i]);
        }
        return true;
    }



}
