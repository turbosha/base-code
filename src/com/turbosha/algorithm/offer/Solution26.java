package com.turbosha.algorithm.offer;

/**
 * #26：树的子结构
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 */
public class Solution26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // B是A的子结构，必要条件有：
        // AB均不能为null  ||  （以节点A为根节点包含B || B是A左子树的子结构 || B是A右子树的子结构）
        return (A != null && B != null) &&
                (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;// B为空，说明B已完成匹配
        if (A == null || A.val != B.val) return false;//A为空，说明B已越过A叶子节点
        return recur(A.left, B.left) && recur(A.right, B.right);
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
