package com.turbosha.algorithm.offer;

/**
 * #24：反转链表
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
public class Solution24 {

    public ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null, next;
        while (cur != null) {
            next = cur.next;// 1、保存下一节点
            cur.next = pre; // 2、将下一节点指向pre
            pre = cur;  // 3、将pre指向cur
            cur = next;  //4、将cur指向next
        }
        return pre; //结束条件是cur==null，故返回pre
    }

    //  Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
