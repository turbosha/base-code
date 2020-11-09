package com.turbosha.algorithm.offer;

/**
 * #14-1：剪绳子1
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 */
public class Solution14_1 {

    /**
     * 经公式推导，3为最优解
     * 最优：3，n为3的整数倍
     * 次优：2，n余2，2保留，不再查分为1
     * 最差：1，n余1，则应把一份3+1替换为2*2，因为2*2>3*1
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if (b == 0) return (int) Math.pow(3, a);
        if (b == 1) return (int) Math.pow(3, a - 1) * 4;
        return (int) Math.pow(3, a) * 2;
    }
}
