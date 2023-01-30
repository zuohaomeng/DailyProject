package com.meng.arithmetic;

import java.util.Arrays;

/**
 * 快排
 *
 * @author ZuoHao
 * @date 2023/1/30
 */
public class QuickSort {
    private static int[] nums = {46, 46, 79, 56, 38, 40, 84, 46};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(QuickSort.nums));
        quickSort(0, nums.length - 1);
        System.out.println(Arrays.toString(QuickSort.nums));

    }

    /**
     * 快排
     */
    private static void quickSort(int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = partition(lo, hi);
        quickSort(lo, mid - 1);
        quickSort(mid + 1, hi);
    }

    private static int partition(int lo, int hi) {
        int k = nums[lo];
        int i = lo + 1;
        int j = hi;
        while (true) {
            while (i <= j && nums[i] <= k) {
                i++;
            }
            while (i <= j && nums[j] > k) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(i, j);
        }
        swap(j, lo);
        return j;
    }

    private static void swap(int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
