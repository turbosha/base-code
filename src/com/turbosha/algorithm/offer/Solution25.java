package com.turbosha.algorithm.offer;

/**
 * #25：合并两个排序的链表
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 */
public class Solution25 {

    /**
     * 伪头部节点
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 构造伪头部节点
        ListNode temp = new ListNode(0), cur = temp;
        while (l1 != null & l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        // 若有链表为空，则将另一个剩余链表接入当前链表
        cur.next = l1 != null ? l1 : l2;
        return temp.next;
    }

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}