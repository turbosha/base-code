package com.turbosha.algorithm.offer;

/**
 * #22：链表中倒数的第K个节点
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class Solution22 {

    /**
     * 定义双指针：前置指针和后指针
     *      1、先将前置指针走k步
     *      2、然后前后指针同时向后移动
     *      3、等到前置指针到头，后置指针即是目标位置
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        for (int i = 0; i < k; i++)
            former = former.next;
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
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
