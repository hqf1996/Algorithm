package Leetcode.搜索;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 13:22 2020/2/26
 * @Modified By:
 */
public class m_417 {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        // 思路：逆流的思想，从边界（某个洋）出发dfs，能流到的点设置为true，最后判断点是否能流到两个大洋即可。
        List<List<Integer>> result = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) {
            return result;
        }
        int n = matrix[0].length;
        boolean[][] OT = new boolean[m][n];  //太平洋
        boolean[][] OD = new boolean[m][n];  //大西洋
        for (int i = 0 ; i < n ; ++i) {
            dfs(matrix, 0, i, OT, m, n, matrix[0][i]);
            dfs(matrix, m-1, i, OD, m, n, matrix[m-1][i]);
        }
        for (int i = 0 ; i < m ; ++i) {
            dfs(matrix, i, 0, OT, m, n, matrix[i][0]);
            dfs(matrix, i, n-1, OD, m, n, matrix[i][n-1]);
        }

        for (int i = 0 ; i < m ; ++i) {
            for (int j = 0 ; j < n ; ++j) {
                if (OD[i][j]== true && OT[i][j]==true) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    result.add(tmp);
                }
            }
        }
        return result;
    }

    public void dfs(int[][] matrix, int i, int j, boolean[][] O, int m, int n, int pre) {
        if (i<0 || j<0 || i>=m || j>=n || O[i][j]==true || matrix[i][j]<pre) {
            return;
        }
        O[i][j] = true;
        dfs(matrix, i-1, j, O, m, n, matrix[i][j]);
        dfs(matrix, i, j-1, O, m, n, matrix[i][j]);
        dfs(matrix, i+1, j, O, m, n, matrix[i][j]);
        dfs(matrix, i, j+1, O, m, n, matrix[i][j]);
    }
}
