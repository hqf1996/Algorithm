package Leetcode.动态规划;

/**
 * @Author: hqf
 * @description: 与95题是类似的题目，只不过需要得到的结果不同
 * @Data: Create in 15:06 2020/2/22
 * @Modified By:
 */
public class m_96 {
    public int numTrees(int n) {
        // 动态规划即可解决
        int []dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2 ; i <= n ; ++i) {
            for (int j = 1 ; j <= i ; ++j) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
