package Leetcode.动态规划;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 17:55 2020/4/19
 * @Modified By:
 */
public class m_516 {
    public int longestPalindromeSubseq(String s) {
        //dp[i][j]定义为s的第i位到第j位的最长回文子序列
        int[][] dp = new int[s.length()+1][s.length()+1];
        for (int i = 1 ; i <= s.length() ; ++i) {
            dp[i][i] = 1;
        }
        // 倒着遍历
        for (int i = s.length() ; i > 0  ; --i) {
            for (int j = i+1 ; j <= s.length() ; ++j) {
                if (s.charAt(i-1) == s.charAt(j-1)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[1][s.length()];
    }
}
