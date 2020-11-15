package com.turbosha.algorithm.offer;

/**
 * #42：连续子数组的最大和
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 */
public class Solution42 {
    /**
     * 动态规划dp：
     *      状态定义：设动态规划列表dp，dp[i]代表以nums[i]为结尾的连续子数组最大和
     *      转移方程：若dp[i-1]<=0，说明dp[i-1]对dp[i]产生负共享，即dp[i-1]+nums[i]<=nums[i]
     *          当dp[i-1]>0时，执行dp[i]=dp[i-1]+nums[i];
     *          当dp[i-1]<=0时，执行dp[i]=nums[i];
 *          初始状态：dp[0]=nums[0]，即以nums[0]结尾的连续子数组最大和为nums[0]
     *      返回值：返回dp列表中的最大值，代表全局最大值
     *
 *      空间复杂度降低：由于dp[i]只与dp[i-1]和nums[i]有关系，因此可以将原数组nums用作 dp列表，
     *      即直接在 nums上修改即可，由于省去dp列表使用的额外空间，空间复杂度从O(N)降至O(1)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 以某个数作为结尾，意思就是这个数一定会加上去
            // 那么要看这个数前面的部分要不要加上去，大于0就加，小于0就舍弃
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);// 每次循环记录最大值
        }
        return res;
    }

}
