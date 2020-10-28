package com.turbosha.algorithm.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * #3:数组中重复的数字
 */
public class Solution3 {

    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 如果当前数组下标元素 != 下标
            if (nums[i] != i) {
                if (nums[nums[i]] != nums[i]) {
                    // 并且 下标值所在索引，索引与索引值也不相同，即均不相同，则交换
                    swap(nums, i, nums[i]);
                } else {
                    // 下标值所在索引上，已有相同值，即重复
                    return nums[i];
                }
            }

        }
        return -1;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * 以空间换时间
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        Set set = new HashSet();
        for (int num : nums) {
            // set如果添加相同元素，返回false
            if (!set.add(num)) return num;
        }
        return -1;
    }
}
