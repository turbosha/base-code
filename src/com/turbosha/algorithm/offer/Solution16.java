package com.turbosha.algorithm.offer;


/**
 * #16：数值的整数次方
 * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/mian-shi-ti-16-shu-zhi-de-zheng-shu-ci-fang-kuai-s/
 */
public class Solution16 {

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        long b = n;
        double res = 1.0;
        // 将n转换为正整数
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        // x循环循环赋值，x=x2 x2=x4...x=xn，倍数n向右移一位
        while (b > 0) {
            // 如果n&1=1，则表示n=1，直接乘以x
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }

}
