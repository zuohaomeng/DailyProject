package com.meng.arithmetic;

import java.util.Arrays;

/**
 * @author ZuoHao
 * @date 2022/1/11
 */
public class SortTest {
    private final static int LIST_LENGTH = 6;
    private static int[] list = {46, 79, 56, 38, 40, 84};
    private static int[] aux = new int[list.length];

    public static void main(String[] args) {
        //--------------------------二分查找--------------------
        Arrays.sort(list);
        printList();
        System.out.println(rank2(46));
        //--------------------------1.选择排序
        selectionSort();
        printList();

        //--------------------------2.冒泡排序
        bubbleSort();
        printList();

        //--------------------------3.插入排序
        insertionSort();
        printList();
        insertionSort2();
        printList();

        //---------------------------4.归并排序
        mergeSort();
        printList();

        //----------------------------5.快速排序
        quickSort();
        printList();

    }

    private static void printList() {
        System.out.println(Arrays.toString(list));
    }

    /**
     * 二分查找
     *
     * @param key
     * @return
     */
    private static int rank2(int key) {
        return rank2(key, 1, list.length - 1);
    }

    private static int rank2(int key, int le, int ri) {
        if (le > ri) {
            return -2;
        }
        int mid = (le + ri) / 2;
        if (key < list[mid]) {
            return rank2(key, le, mid - 1);
        } else if (key > list[mid]) {
            return rank2(key, mid + 1, ri);
        }
        return mid;
    }

    private static int rank(int key, int left, int right) {

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (key == list[mid]) {
                return mid;
            }
            if (list[mid] > key)
                right = mid - 1;
            if (list[mid] < key)
                left = mid + 1;

        }
        return -1;
    }

    /**
     * 选择排序
     */
    private static void selectionSort() {
        for (int i = 0; i < list.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.length - 1; j++) {
                if (list[minIndex] > list[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                exchange(i, minIndex);
            }
        }
    }

    /**
     * 冒泡排序
     */
    private static void bubbleSort() {
        for (int i = 0; i < list.length - 1; i++) {
            boolean isExchange = false;
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j] > list[j + 1]) {
                    exchange(j, j + 1);
                    isExchange = true;
                }
            }
            //没有交换了直接结束
            if (!isExchange) {
                break;
            }
        }
    }

    private static void insertionSort() {
        for (int i = 1; i < list.length; i++) {
            for (int j = i; j > 0; j--) {
                if (list[j - 1] > list[j]) {
                    exchange(j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    private static void insertSort() {
        for (int i = 1; i < list.length; i++) {
            for (int j = i; j > 0; j--) {
                if (list[j - 1] > list[j]) {
                    exchange(j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 插入排序(有些改进)
     */
    private static void insertionSort2() {
        for (int i = 1; i < list.length - 1; i++) {
            int data = list[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (list[j] > data) {
                    list[j + 1] = list[j];//向后移一位
                } else {//不交换就可以推出了
                    break;
                }
            }
            list[j + 1] = data;
        }
    }

    /**
     * 归并排序
     */
    private static void mergeSort() {
        mergeSort(0, LIST_LENGTH - 1);
    }

    private static void mergeSort(int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + ((hi - lo) >> 1);
        mergeSort(lo, mid);
        mergeSort(mid + 1, hi);
        mergeSort(lo, mid, hi);
    }

    private static void mergeSort(int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = list[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i == mid + 1) list[k] = aux[j++];
            else if (j == hi + 1) list[k] = aux[i++];
            else if (aux[i] <= aux[j]) list[k] = aux[i++];
            else list[k] = aux[j++];
        }
    }

    /**
     * 快速排序
     */
    private static void quickSort() {
        quickSort(0, list.length - 1);
    }

    private static void quickSort(int le, int ri) {
        if (le >= ri) return;
        int mid = partition(le, ri);
        quickSort(le, mid - 1);
        quickSort(mid + 1, ri);
    }

    private static int partition(int le, int ri) {
        int i = le;
        int j = ri + 1;
        int k = list[le];
        while (i < j) {
            while (list[++i] <= k) {
                if (i == ri) break;
            }
            while (list[--j] > k) {
                if (j == le) break;
            }
            if (i >= j) {
                break;
            }
            exchange(i, j);
        }
        exchange(j, le);
        return j;
    }


    private static void exchange(int a, int b) {
        int t = list[a];
        list[a] = list[b];
        list[b] = t;
    }
}
