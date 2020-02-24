package Leetcode.搜索;

import java.util.Stack;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 15:25 2020/2/24
 * @Modified By:
 */
public class m_200 {
    int[][] direct = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        // 思路:dfs
        // 递归
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        int num = 0;
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, m, n);
//                    dfs2(grid, i, j, m, n);
                    num++;
                }
            }
        }
        return num;
    }

    // 递归写法
    public void dfs(char[][] grid, int i, int j, int m, int n) {
        if (i<0 || j<0 || i>=m || j>=n || grid[i][j]=='0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i+1, j, m, n);
        dfs(grid, i-1, j, m, n);
        dfs(grid, i, j+1, m, n);
        dfs(grid, i, j-1, m, n);
    }

    // 非递归写法
    public void dfs2(char[][] grid, int i, int j, int m, int n) {
        Stack<int []> stack = new Stack<>();
        stack.push(new int[]{i, j});
        while (!stack.isEmpty()) {
            int[] tmp = stack.pop();
            grid[tmp[0]][tmp[1]] = '0';
            for (int[] eachDirect : direct) {
                int x = tmp[0] + eachDirect[0];
                int y = tmp[1] + eachDirect[1];
                if (x<0 || y<0 || x>=m || y>=n || grid[x][y]=='0') {
                    continue;
                }
                stack.push(new int[]{x, y});
            }
        }
    }
}
