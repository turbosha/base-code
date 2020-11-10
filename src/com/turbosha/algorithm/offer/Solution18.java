package com.turbosha.algorithm.offer;

/**
 * #18：删除链表的节点
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class Solution18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        // 保存前一节点，及当前节点
        ListNode pre = head;
        ListNode now = pre.next;
        while (now != null) {
            if (now.val == val) pre.next = now.next;
            pre = now;
            now = now.next;
        }
        return head;
    }


    // Definition for singly-linked list.
    public class ListNode {
        int val;

        ListNode(int x) {
            val = x;
        }

        ListNode next;
    }
}



