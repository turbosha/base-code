package com.turbosha.algorithm.offer;

/**
 * #14-2：剪绳子2
 * https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/
 */
public class Solution14_2 {
    public static void main(String[] args) {
        Solution14_2 s = new Solution14_2();
        s.cuttingRope(10);
    }

    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int p = 1000000007;
        long res = 1;
        while (n > 4) {
            res *= 3;
            res %= p;
            n -= 3;
        }
        // 因为上面是  n>4
        // n=8-->5时，继续循环
        // n=7-->4时，拆分为2*2=4
        // n=6-->3时，直接乘以3
        // n=5-->2时，直接乘以2
        // n=4-->退出循环，2*2=4
        // 所以结果是2时，直接乘以3
        return (int) (res * n % p);
    }

}
