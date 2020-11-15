package com.turbosha.algorithm.offer;

/**
 * #40：最小的k个数
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class Solution40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        // 使用快排，将所有元素进行排序，然后取k位数即可
        quickSort(arr, 0, arr.length - 1);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = arr[i];
        return res;
    }

    private void quickSort(int[] arr, int left, int right) {
        int i = left, j = right, temp = arr[i];
        while (i < j) {
            while (i < j && arr[j] >= temp) j--;
            if (i < j) arr[i++] = arr[j];
            while (i < j && arr[i] <= temp) i++;
            if (i < j) arr[j--] = arr[i];
        }
        arr[i] = temp;
        if (left < i) quickSort(arr, left, i - 1);
        if (j < right) quickSort(arr, j + 1, right);
    }
}
