package com.turbosha.algorithm.offer;

/**
 * #27：二叉树的镜像
 */
public class Solution27 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        // 先交换左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 再递归左右子树交换
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }


//    ==============原始版

    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) return null;
        recur(root);
        return root;
    }

    private void recur(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        recur(root.left);
        recur(root.right);
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
