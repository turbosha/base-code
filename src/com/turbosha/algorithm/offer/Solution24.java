package com.turbosha.algorithm.offer;

/**
 * #24：反转链表
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
public class Solution24 {
    public ListNode reverseList(ListNode head) {
        ListNode cur=head,pre=null,next;
        while (cur!=null){
            next=cur.next; // 首先保存 next
            cur.next=pre; // 将当前节点的后继节点，执行pre
            pre=cur; // 将 pre后移，变成 cur
            cur=next; // 将cur后移，变成 next
        }
        // 因为cur为null了，所以取pre
        return pre;
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
