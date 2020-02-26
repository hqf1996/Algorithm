package Leetcode.搜索.回溯;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 16:49 2020/2/26
 * @Modified By:
 */
public class m_79 {
    int[][] direct = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean exist(char[][] board, String word) {
        // dfs
        if (board.length == 0) {
            if (word.equals("")) {
                return true;
            } else {
                return false;
            }
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] flag = new boolean[m][n];
        for (int i = 0 ; i < m ; ++i) {
            for (int j = 0 ; j < n ; ++j) {
                if (backTracing(board, flag, i, j, m, n, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTracing(char[][] board, boolean[][] flag, int i, int j, int m, int n, String word, int k) {
        if (k == word.length()) {
            return true;
        }
        if (i<0 || j<0 || i>=m || j>=n || board[i][j]!=word.charAt(k) || flag[i][j]) {
            return false;
        }
        flag[i][j] = true;
        for (int[] eachDirect : direct) {
            int x = i+eachDirect[0];
            int y = j+eachDirect[1];
            if (backTracing(board, flag, x, y, m, n, word, k+1)) {
                return true;
            }
        }
        flag[i][j] = false;
        return false;
    }
}
