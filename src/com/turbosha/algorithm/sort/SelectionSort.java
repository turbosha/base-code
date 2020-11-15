package com.turbosha.algorithm.sort;

import java.util.Arrays;

/**
 * 简单选择排序：时间复杂度O(n^2)
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 5, 6, 1, 5, 2, 8, 9, 6, 3, 4, 7, 5, 1, 2, 5, 6, 8, 9, 4, 5, 6, 1, 2, 3, 5, 4, 8, 6, 5, 8};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void selectSort(int[] arrs) {
        for (int i = 0; i < arrs.length - 1; i++) { // 每次比较确定一个最小值，故需要n-1轮比较
            int min = i; // 初始最小下标指向首个元素
            for (int j = i + 1; j < arrs.length ; j++) { //比较元素起始下标为 首元素+1，一直比较到末尾  arr.length-1
                if (arrs[min] > arrs[j]) min = j;
            }
            int temp = arrs[i];
            arrs[i] = arrs[min];
            arrs[min] = temp;
        }
    }
}
