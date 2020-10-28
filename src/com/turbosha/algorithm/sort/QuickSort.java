package com.turbosha.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    public static void quickSort(int[] arr, int left, int right) {
        int i = left, j = right, base = arr[left];
        while (i < j) {
            while (i < j && arr[j] >= base) j--;
            if (i < j) arr[i++] = arr[j];
            while (i < j && arr[i] <= base) i++;
            if (i < j) arr[j--] = arr[i];
        }
        arr[i] = base;
        // i~j 之间的数据就已经顺序了
        if (i > left) quickSort(arr, left, i - 1);// 计算 left ~ i-1
        if (j < right) quickSort(arr, j + 1, right);// 计算 j+1 ~ right
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 5, 4, 6, 44, 9, 65, 62, 6, 9, 56, 56, 2, 62, 65, 95, 5, 23, 9, 562, 6, 95, 6, 59, 465, 65, 95, 9};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
