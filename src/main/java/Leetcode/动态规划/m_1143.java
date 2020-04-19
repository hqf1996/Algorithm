package Leetcode.动态规划;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 16:29 2020/4/19
 * @Modified By:
 */
public class m_1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        // 动态规划问题
        // dp[i][j]在这里表示串1的[0...i]与串2的[0...j]的最长字串的长度
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for (int i = 1 ; i < text1.length()+1 ; ++i) {
            for (int j = 1 ; j < text2.length()+1 ; ++j) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
