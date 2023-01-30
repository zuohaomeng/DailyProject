package com.meng.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列
 *
 * @author ZuoHao
 * @date 2022/1/30
 */
public class FullArrange {
    public static void main(String[] args) {
        String[] abcs = new FullArrange().permutation("abc");
        Arrays.stream(abcs).forEach(System.out::println);
    }

    public String[] permutation(String s) {
        ArrayList<String> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        fullArrange(list, chars, 0, chars.length - 1);
        return list.toArray(new String[0]);
    }

    private void fullArrange(List<String> list, char[] chars, int start, int end) {
        if (start == end) {
            list.add(new String(chars));
            return;
        }
        for (int i = start; i <= end; i++) {
            //1，2，3的全排列这块相当于将其中一个提了出来，下次递归从start+1开始
            swap(chars, start, i);
            fullArrange(list, chars, start + 1, end);
            //复原数组
            swap(chars, start, i);
        }
    }

    private void swap(char[] chars, int a, int b) {
        char t = chars[a];
        chars[a] = chars[b];
        chars[b] = t;
    }
}
