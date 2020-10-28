package com.turbosha.algorithm.leetcode;

/**
 * @Description #1：两数之和 简单
 * https://leetcode-cn.com/problems/two-sum/
 * @Author luoyuansha
 * @Date 2020/10/28 14:03
 */
public class Solution1 {

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return null;
    }
}
