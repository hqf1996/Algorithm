package Leetcode.动态规划;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 21:20 2020/7/17
 * @Modified By:
 */
public class s_121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] dp = new int[prices.length];
        int tmpA = 0;
        int tmpB = 0;
        int min = prices[0];
        dp[0] = 0;
        for (int i = 1 ; i < prices.length ; ++i) {
            min = Math.min(min, prices[i]);
            tmpB = Math.max(tmpA, prices[i]-min);
            tmpA = tmpB;
        }
        return tmpA;
    }
}
