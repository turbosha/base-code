package com.turbosha.algorithm.offer;

/**
 * #28：对称的二叉树
 */
public class Solution28 {
    /**
     * 对称二叉树条件：
     * 1、树为空
     * 2、从根节点开始：
     *      左右都为null
     *  或  左子树.v==右子树.v && 左子树.左==右子树.右 && 左子树.右==右子树.左
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return recur(root.left, root.right);

    }

    private boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right != null) return false;
        if (left != null && right == null) return false;
        if (left == null && right == null) return true;
        return left.val == right.val
                && recur(left.left, right.right)
                && recur(left.right, right.left);
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
