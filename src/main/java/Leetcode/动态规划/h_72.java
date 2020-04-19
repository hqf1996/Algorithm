package Leetcode.动态规划;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 22:06 2020/4/5
 * @Modified By:
 */
public class h_72 {
    public int minDistance(String word1, String word2) {
        // db[i][j] 代表子串word1[0...i]和word2[0...j]的编辑距离
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0 ; i <= m ; ++i) {
            dp[i][0] = i;
        }
        for (int i = 0 ; i <= n ; ++i) {
            dp[0][i] = i;
        }

        for (int i = 1 ; i <= m ; ++i) {
            for (int j = 1 ; j <= n ; ++j) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = min(dp[i-1][j]+1, dp[i][j-1]+1, dp[i-1][j-1]+1);
                }
            }
        }
        return dp[m][n];
    }

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
