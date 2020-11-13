package com.turbosha.algorithm.offer;

import java.util.Stack;

/**
 * #31：栈的压入、弹出序列
 */
public class Solution31 {


    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 借助辅助栈，模拟入栈、出栈
        // 因栈内数字不相等，则遇见相同的数字即可弹出
        Stack<Integer> stack = new Stack();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && popped[i] == stack.peek()) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
