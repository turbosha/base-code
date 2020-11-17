package com.turbosha.algorithm.offer;

/**
 * #52：两个链表的第一个公共节点
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 */
public class Solution52 {

    /**
     * 双指针node1、node2分别指向两个链表，然后同时分别逐结点遍历
     * 当node1达到链表headA末尾时，重新定位到链表headB，node2同理
     * 当node1==node2时，即所指的结点就是第一个公共结点
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA, node2 = headB;
        while (node1 != node2) {
            node1 = node1 != null ? node1.next : headB;
            node2 = node2 != null ? node2.next : headA;
        }
        return node1;
    }


    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
