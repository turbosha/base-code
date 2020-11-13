package com.turbosha.algorithm.offer;

/**
 * #33：二叉搜索树的后序遍历序列
 */
public class Solution33 {

    /**
     * 性质：
     * 后序遍历：左、右、根
     * 二叉搜索树：左子树<=根节点<=右子树
     * 思路，区间内寻找第一个比根节点大的值，即可划分左右子树
     *
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int i, int j) {
        if (i >= j) return true; //说明子树节点数量<=1，直接返回true
        int p = 0;
        // 因为树内数字互不相同，故 左子树<根节点<右子树
        while (postorder[p] < postorder[j]) p++;
        int m = p; // 划分左右子树。左子树[i,m-1]、右子树[m,j-1]、根索引j
        while (postorder[p] > postorder[j]) p++;
        // p==j验证树的正确性
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m , j-1);
    }
}
