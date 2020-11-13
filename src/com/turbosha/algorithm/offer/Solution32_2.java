package com.turbosha.algorithm.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * #32-2：从上到下打印二叉树II
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 */
public class Solution32_2 {
    /**
     * 层序遍历BFS，通常借助队列的先入先出特性来实现
     * 此题要求，每一层打印一行，每一层从左到右，则需要到每一层装完后即可进入下一次
     * 因此，判断条件是，当前层是否都装完了
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        if (root != null) queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            List temp = new ArrayList();
            // 因为后续queuq在添加元素，故不可使用 queue.size()作为循环判断条件
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(temp);
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


