package Leetcode.搜索;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 10:28 2020/2/23
 * @Modified By:
 */
public class m_1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // bfs求最短路径
        int m = grid.length;  // m行
        int n = grid[0].length;  // n列
        int [][]direct = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) {
            return -1;
        }
        if (m==1 && n==1 && grid[0][0]==0) {
            return 1;
        }
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        grid[0][0] = 1; //赋值为1表示已经遍历到了
        int layer = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            layer++;
            while (size > 0) {
                int []node = queue.poll();
                size--;
                // 遍历周围8个方向上的点
                for (int []eachDirect : direct) {
                    int x = node[0] + eachDirect[0];
                    int y = node[1] + eachDirect[1];
                    if (x<0 || y<0 || x>=m || y>=n || grid[x][y]==1) {
                        continue;
                    }
                    if (x == m-1 && y == n-1) {
                        return layer;
                    }
                    queue.add(new int[]{x, y});
                    grid[x][y] = 1;
                }
            }
        }
        return -1;
    }
}
