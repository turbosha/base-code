package com.turbosha.algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序：时间复杂度O(nlogn)
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 5, 6, 1, 5, 2, 8, 9, 6, 3, 4, 7, 5, 1, 2, 5, 6, 8, 9, 4, 5, 6, 1, 2, 3, 5, 4, 8, 6, 5, 8};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arrs) {
        // gap初始为 leng/2
        int gap = arrs.length / 2;
        while (gap >= 1) {
            // 把距离为gap的编为一个组，扫描所有组，i++依次向后移动时，各gap分组均已有序
            for (int i = gap; i < arrs.length; i++) {
                int temp = arrs[i], j;
                // 与简单插入排序一致，只是将-1变为-gap
                for (j = i - gap; j >= 0 && temp < arrs[j]; j -= gap) {
                    arrs[j + gap] = arrs[j];
                }
                arrs[j + gap] = temp;
            }
            gap /= 2;
        }

    }
}
