package Leetcode.搜索.回溯;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 11:26 2020/2/29
 * @Modified By:
 */
public class h_37 {
    // 记录第i行已经用过的数为true
    boolean[][] rowsFlag = new boolean[9][10];
    // 记录第i列已经用过的数为true
    boolean[][] colsFlag = new boolean[9][10];
    // 记录第i个九宫格内已经用过的数为true
    boolean[][] RCFlag = new boolean[9][10];
    public void solveSudoku(char[][] board) {
        // 回溯
        // 初始化已经用过的数字
        for (int i = 0 ; i < 9 ; ++i) {
            for (int j = 0 ; j < 9 ;++j) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j]-'0';
                rowsFlag[i][num] = true;
                colsFlag[j][num] = true;
                RCFlag[change(i, j)][num] = true;
            }
        }
        backTracing(board, 0, 0);
    }

    public boolean backTracing(char[][] board, int i, int j) {
        while (i<9 && j<9 && board[i][j]!='.') {
            j = (j+1) % 9;
            i = (j==0)?i+1:i;
        }
        if (i == 9) {
            return true;
        }
        for (int k = 1 ; k <= 9 ; ++k) {
            if (rowsFlag[i][k]==false && colsFlag[j][k]==false && RCFlag[change(i, j)][k]==false) {
                rowsFlag[i][k]=true;
                colsFlag[j][k]=true;
                RCFlag[change(i, j)][k]=true;
                board[i][j]=(char)(k+'0');
                if (backTracing(board, i, j)) {
                    return true;
                }
                rowsFlag[i][k]=false;
                colsFlag[j][k]=false;
                RCFlag[change(i, j)][k]=false;
                board[i][j]='.';
            }
        }
        return false;
    }

    // 判断某行某列的数在第几个九宫格内
    public int change(int i, int j) {
        if (i>=0 && i<=2) {
            return j/3;
        } else if (i>=3 && i<=5) {
            return 3+j/3;
        } else if (i>=6 && i<=8) {
            return 6+j/3;
        }
        return -1;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        h_37 h = new h_37();
        h.solveSudoku(board);
    }
}
