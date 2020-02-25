package Leetcode.搜索;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 15:43 2020/2/25
 * @Modified By:
 */
public class m_130 {
    public void solve(char[][] board) {
        // 思路：dfs，反向考虑，只需要保留最后边界上的'O'的区域，也就是不被包围的'O'的区域，这边变成另一种符号记录下来，然后将图中所有的o和x都变成x，将另一种符号的点变成o点即可。
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        // 遍历边界
        for (int i = 0 ; i < n ; ++i) {
            dfs(board, 0, i, m, n);
            dfs(board, m-1, i, m, n);
        }
        for (int i = 0 ; i < m ; ++i) {
            dfs(board, i, 0, m, n);
            dfs(board, i, n-1, m, n);
        }

        for (int i = 0 ; i < m ; ++i) {
            for (int j = 0 ; j < n ; ++j) {
                if (board[i][j]=='A') {
                    board[i][j]='O';
                } else {
                    board[i][j]='X';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j, int m, int n) {
        if (i<0 || j<0 || i>=m || j>=n || board[i][j]!='O') {
            return;
        }
        board[i][j]='A';
        dfs(board, i-1, j, m, n);
        dfs(board, i+1, j, m, n);
        dfs(board, i, j-1, m, n);
        dfs(board, i, j+1, m, n);
    }
}
