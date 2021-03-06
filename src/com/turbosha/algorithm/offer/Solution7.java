package com.turbosha.algorithm.offer;

import java.util.HashMap;

/**
 * #7：重建二叉树
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 */
public class Solution7 {

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        Solution7 s = new Solution7();
        s.buildTree(preorder, inorder);
    }

    // 利用原理，先序遍历的第一个节点就是根。在中序遍历中通过根，区分哪些是左子树、右子树
    // 左右子树，递归
    int[] preorder;// 保留的先序遍历
    HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);// 将中序遍历的值跟索引放入map中
        return recur(0, 0, inorder.length - 1);
    }

    /**
     * @param root 先序遍历的索引-根节点索引
     * @param left 中序遍历的左边界
     * @param right 中序遍历的右边界
     * @return
     */
    TreeNode recur(int root, int left, int right) {
        if(left > right) return null;                          // 递归终止。越过根节点了
        TreeNode node = new TreeNode(preorder[root]);          // 建立根节点
        int i = dic.get(preorder[root]);                       // 划分根节点、左子树、右子树
        node.left = recur(root + 1, left, i - 1);              // 开启左子树递归
        node.right = recur(root + i - left + 1, i + 1, right); // 开启右子树递归
        return node;                                           // 回溯返回根节点
    }

    /**
     * 二叉树性质：
     * 前序遍历：根左右、中序遍历：左根右
     * 思路：分治算法
     * 1、使用前序遍历的根节点，到中序遍历区分出左右子树
     * 2、根据左右子树数量，到前序遍历中区分左右子树
     * 可使用前序遍历的根节点，区分出中序遍历的左右子树节点，再根据
     *
     * @param preorder
     * @param inorder
     * @return
     */
    int preindex = 0; // 记录前序遍历指针
    int inindex = 0; // 记录中序遍历指针

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        return dfs(preorder, inorder, null);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, TreeNode finish) {
        // 终止条件，前序遍历到达边界 || 父节点存在，且中序遍历当前指针指向自己时，（左根右）说明无左子树
        if (preindex == preorder.length || (finish != null && inorder[inindex] == finish.val)) return null;
        // 遍历过程，数组内每一个元素都是节点
        // 故共有 preorder.length个节点
        TreeNode root = new TreeNode(preorder[preindex++]);
        // 左子树，用当前节点，去寻找左子树
        // 如果中序遍历中，当前指针节点=当前节点，根据 左根右，说明无左子树
        root.left = dfs(preorder, inorder, root);
        // 右子树
        inindex++; // 中序遍历指针，用以记录建立的右子树关系，共有 inorder.length个子树需要建立关系
        // 使用当前节点的父节点区寻找当前节点的右子树
        root.right = dfs(preorder, inorder, finish);
        return root;
    }


    /**
     * 提供的二叉树结构
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

