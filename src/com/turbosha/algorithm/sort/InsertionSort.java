package com.turbosha.algorithm.sort;

import java.util.Arrays;

/**
 * 直接插入排序：时间复杂度O(n^2)
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 5, 6, 1, 5, 2, 8, 9, 6, 3, 4, 7, 5, 1, 2, 5, 6, 8, 9, 4, 5, 6, 1, 2, 3, 5, 4, 8, 6, 5, 8};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arrs) {
        // 从1~leng-1轮次，选取首个元素，与有序数组进行比较
        for (int i = 1; i < arrs.length; i++) {
            int temp = arrs[i], j;
            // 若temp<有序数组，则有序数组右移，否则插入该值
            for (j = i - 1; j >= 0 && temp < arrs[j]; j--) {
                arrs[j + 1] = arrs[j];
            }
            arrs[j + 1] = temp;
        }
    }
}
