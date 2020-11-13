package com.turbosha.algorithm.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * #32-3：从上到下打印二叉树III
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 */
public class Solution32_3 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        int x = 0; // 定义x，因 x&1==1，表示x为奇数， x&1==0 表示偶数
        while (!queue.isEmpty()) {
            List temp = new ArrayList();
            for (int size = queue.size(); size > 0; size--) {
                if ((x & 1) == 1) {
                    // 因为双端队列在同时取存，故方向必须相反
                    TreeNode node = queue.pollLast();
                    temp.add(node.val);
                    if (node.right != null) queue.addFirst(node.right);
                    if (node.left != null) queue.addFirst(node.left);
                } else {
                    TreeNode node = queue.pollFirst();
                    temp.add(node.val);
                    if (node.left != null) queue.addLast(node.left);
                    if (node.right != null) queue.addLast(node.right);
                }
            }
            res.add(temp);
            x++;
        }
        return res;
    }


    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
