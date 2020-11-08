package com.turbosha.algorithm.offer;


import java.util.ArrayList;
import java.util.List;

/**
 * #6:从头到尾打印链表
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class Solution6 {
    List<Integer> list = new ArrayList();

    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[]{};
        recur(head);
        // 将元素加入数组
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    // 从尾节点依次向前添加元素
    public void recur(ListNode node) {
        if (node.next != null) recur(node.next);
        list.add(node.val);
    }


    /**
     * 将所有元素一次加入List，再将List倒序加入数组
     * @param head
     * @return
     */
    public int[] reversePrint2(ListNode head) {
        if (head == null) return new int[]{};
        List<Integer> list = new ArrayList();
        list.add(head.val);
        while (head.next != null) {
            head = head.next;
            list.add(head.val);
        }
        int size = list.size(),j=0;
        int[] arr = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            arr[j++]=list.get(i);
        }
        return arr;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
