package com.turbosha.algorithm.offer;

import java.util.Arrays;

/**
 * #21：调整数组顺序使奇数位于偶数的前面
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
public class Solution21 {

    public static void main(String[] args) {
        Solution21 s=new Solution21();
        int[] exchange = s.exchange(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(exchange));
    }

    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            while (i < j && (nums[i] & 1) == 1) i++;// n&1=1，n为奇数
            while (i < j && (nums[j] & 1) == 0) j--;// n&1=0，n为偶数
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}
