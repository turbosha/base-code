package com.turbosha.algorithm.offer;

/**
 * #12：矩阵中的路径
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 */
public class Solution12 {

    /**
     * 深度优先搜索dfs
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 起始条件，从矩阵（0,0）开始寻找第一个符合的元素
                dfs(board, words, i, j, 0);
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        // 指针均在长度内，且当前坐标等于 word当前索引的值，k为word的索引
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0 || word[k] != board[i][j]) return false;
        if (k == word.length - 1) return true;
        char temp = board[i][j];
        board[i][j] = '/';
        // 深度搜索，定义  下、上、右、左
        boolean res = dfs(board, word, i + 1, j, k) || dfs(board, word, i - 1, j, k)
                || dfs(board, word, i, j + 1, k) || dfs(board, word, i, j - 1, k);
        board[i][j] = temp;// 这里值需要还原，因为后续递归需要使用
        return res;
    }


}