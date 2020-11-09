package com.turbosha.algorithm.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * #13：机器人的运动范围
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class Solution13 {

    /**
     * 深度优先搜索实现dfs
     */
    int m, n, k;
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }

    private int dfs(int i, int j, int si, int sj) {
        if (i >= m || j >= n || k < si + sj || visited[i][j]) return 0;
        visited[i][j] = true;
        // 设x的数位和为Sx，x+1的数位和为Sx+1，由于 1<m,n<100
        // 故有公式： 当(x+1)%10==0时，Sx+1=Sx-8; 即x+1为10的倍数时，x与x+1的数位和相差8
        // 当 (x+1)/10==0时，Sx+1=Sx+1; 即x+1小于10时，x与x+1的数位和相差1

        // dfs设定下、右方向。先递归深度，然后再返回
        // 这里的1是因为到达这里了，所以是1，否则判断条件在第一行就返回了
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj)
                + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }

    //============================================================================================

    /**
     * 广度优先搜索实现bfs
     */
    public int movingCount2(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 0});
        // 队列中先加入下、右，然后随广度依次推进
        while (queue.size() > 0) {
            int[] x = queue.poll();
            int i = x[0], j = x[1], si = x[2], sj = x[3];
            // 临界条件
            if (i >= m || j >= n || k < si + sj || visited[i][j]) continue;
            visited[i][j] = true;
            res++;
            // bfd设定下、右方向，与dfs一致
            queue.add(new int[]{i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj});
            queue.add(new int[]{i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8});
        }
        return res;
    }


}
