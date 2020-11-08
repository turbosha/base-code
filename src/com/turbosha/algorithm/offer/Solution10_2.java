package com.turbosha.algorithm.offer;

/**
 * #10-2：青蛙跳台阶问题
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 */
public class Solution10_2 {
    // f(0)=1,f(1)=1,f(2)=2
    public int numWays(int n) {
        // a为n-2,b为n-1,sum为n
        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++) {
            // f(n)=f(n-2)+f(n-1)
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
