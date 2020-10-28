package com.turbosha.algorithm.offer;

/**
 * #4：二维数组中的查找
 */
public class Solution4 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[][] arr = {{3, 3, 8, 13, 13, 18}, {4, 5, 11, 13, 18, 20}, {9, 9, 14, 15, 23, 23}, {13, 18, 22, 22, 25, 27}, {18, 22, 23, 28, 30, 33}, {21, 25, 28, 30, 35, 35}, {24, 25, 33, 36, 37, 40}};
        boolean result = solution4.findNumberIn2DArray(arr, 21);
        System.out.println(result);

    }

    /**
     * 牛客网解答，思路：
     * 左边的均小于当前数，下边的数一定大于当前数
     * 即可从右上-->左下
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, c = cols - 1; // 从右上角开始
        // 确定边界条件
        while (r < rows && c >= 0) {
            if (target == matrix[r][c]) {
                return true;
            } else if (target > matrix[r][c]) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }


    /**
     * 自己做的，思路：
     * 1、大于当前数，且未向左，向右
     * 2、小于当前数，且未向左，向左
     * 3、大于当前数，且已向左，向下
     * 4、小于当前数，且到左边界，向下
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        boolean res;
        if (matrix.length == 0) return false;
        int i = 0;
        int j = 0;
        while (true) {
            int[] ints = matrix[i];
            j = find(ints, j, target);
            if (j < 0) {
                res = true;
                break;
            }
            i++;
            if (i == matrix.length) {
                res = false;
                break;
            }
        }
        return res;
    }

    public int find(int[] ints, int begin, int target) {
        if (ints.length == 0) return 0;
        boolean left = false;
        for (int i = begin; i < ints.length; i++) {
            if (target == ints[i]) return -1;
            if (target > ints[i]) {
                if (left) return i;
            }
            if (target < ints[i]) {
                if (i > begin) {
                    // i比起始值大，说明已经走过，返回下一层起始下标
                    return i - 1;
                } else {
                    // i等于起始值，可以往左走
                    if (i == 0) {
                        // 往下走
                        return 0;
                    } else {
                        i = i - 2;
                        left = true;
                    }
                }
            }
        }
        return ints.length - 1;
    }
}
