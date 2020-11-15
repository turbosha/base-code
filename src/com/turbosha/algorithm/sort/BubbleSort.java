package com.turbosha.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序：时间复杂度O(n^2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr=new int[]{2,4,5,6,1,5,2,8,9,6,3,4,7,5,1,2,5,6,8,9,4,5,6,1,2,3,5,4,8,6,5,8};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void bubbleSort(int[] arrs) {
        for (int i = 0; i < arrs.length-1; i++) {  // n个数，每轮确定一个最大值，需要n-1轮
            for (int j = 0; j < arrs.length-1-i; j++) {  // 每轮比较的次数为 n-1-i
                if(arrs[j]>arrs[j+1]){
                    int temp = arrs[j];
                    arrs[j]=arrs[j+1];
                    arrs[j+1]=temp;
                }
            }
        }
    }
}
