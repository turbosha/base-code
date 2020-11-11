package com.turbosha.algorithm.offer;

import java.util.Stack;

/**
 * #30：包含min函数的栈
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 */
public class MinStack {

    Stack<Integer> A;
    Stack<Integer> B;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.add(x);
        if (B.isEmpty() || B.peek() >= x) B.push(x);
    }

    public void pop() {
        if (A.pop() == B.peek().intValue()) B.pop();
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */