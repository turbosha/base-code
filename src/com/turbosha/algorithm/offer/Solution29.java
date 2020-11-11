package com.turbosha.algorithm.offer;

/**
 * #29：顺时针打印矩阵
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 */
public class Solution29 {


    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        // 分别设定上下左右四个边界，添加完一边后，边界-1，对立边界不可跨越
        int x = 0;
        int left = 0, right = matrix[0].length - 1;
        int up = 0, down = matrix.length - 1;
        int[] arr = new int[(right + 1) * (down + 1)];
        while (true) {
            for (int i = left; i <= right; i++) arr[x++] = matrix[up][i];//从左到右
            if (++up > down) break;
            for (int i = up; i <= down; i++) arr[x++] = matrix[i][right];//从上到下
            if (--right < left) break;
            for (int i = right; i >= left; i--) arr[x++] = matrix[down][i];//从右到左
            if (--down < up) break;
            for (int i = down; i >= up; i--) arr[x++] = matrix[i][left];//从下到上
            if (++left > right) break;
        }
        return arr;
    }
}
