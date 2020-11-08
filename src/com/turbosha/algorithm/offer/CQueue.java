package com.turbosha.algorithm.offer;

import java.util.Stack;

/**
 * #9：用两个栈实现队列
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class CQueue {

    Stack<Integer> in = new Stack();
    Stack<Integer> out = new Stack();

    public CQueue() {

    }

    public void appendTail(int value) {
        in.add(value);
    }

    public int deleteHead() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.add(in.pop());
            }
        }
        if (out.isEmpty()) return -1;
        return out.pop();
    }
}
/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
