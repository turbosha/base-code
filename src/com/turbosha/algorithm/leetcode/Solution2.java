package com.turbosha.algorithm.leetcode;

/**
 * @Description #2：两数相加 中等
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @Author luoyuansha
 * @Date 2020/10/28 14:04
 */
public class Solution2 {

    /**
     * 官方解答
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // val为链表等位的两数之和，t为进数
        int val = l1.val + l2.val, t = 0;
        ListNode node;
        if (val < 10) {
            node = new ListNode(val);
        } else {
            t = 1;
            node = new ListNode(val % 10);
        }
        ListNode node1 = l1.next;
        ListNode node2 = l2.next;
        if (node1 == null && node2 == null) {
            if (t > 0) node.next = new ListNode(1);
            return node;
        }
        if (node1 == null) node1 = new ListNode(0);
        if (node2 == null) node2 = new ListNode(0);
        node1.val += t;
        node.next = addTwoNumbers(node1, node2);
        return node;
    }

    /**
     * 提供的数据结构
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
