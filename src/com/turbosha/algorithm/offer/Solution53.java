package com.turbosha.algorithm.offer;

/**
 * #53-1：在排序数组中查找数字I
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */
public class Solution53 {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int m, i, j, num = 1;
        while (left <= right) {
            m = (right + left) / 2;
            if (nums[m] == target) {
                i = j = m; // 值相等时，往左右边界开始寻找相等值，返回即可
                while (i < right && nums[++i] == target) num++;
                while (j > left && nums[--j] == target) num++;
                return num;
            }
            if (nums[m] < target) {
                left = m + 1; // 缩小边界
            } else {
                right = m - 1;
            }
        }
        return 0;
    }
}
