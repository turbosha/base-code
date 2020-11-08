package com.turbosha.algorithm.offer;

/**
 * #10.斐波那契数列
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class Solution10 {

    public static void main(String[] args) {
        Solution10 s = new Solution10();
        System.out.println(s.fib(48));
    }

    public int fib(int n) {
        if (n == 0) return 0;
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
            fib[i] = fib[i] % 1000000007;
        }
        return fib[n] % 1000000007;
    }
}
