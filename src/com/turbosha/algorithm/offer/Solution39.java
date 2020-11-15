package com.turbosha.algorithm.offer;


/**
 * #39：数组中出现次数超过一半的数字
 */
public class Solution39 {
    /**
     * 摩尔投票法：票数正负抵消
     * 设输入数组的nums的众数为x，数组长度为n
     * 推论一：若众数+1，非众数-1，则一定有所有数字的票数和>0；
     * 推论二：若数组前a个数字的票数和为0，则数组剩余(n-a)个数字的票数和一定仍>0，即后(n-a)个数字的众数和仍为x
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}
