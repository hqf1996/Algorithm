package Leetcode.动态规划;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 21:12 2020/7/17
 * @Modified By:
 */
public class h_123 {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][][] dp = new int[prices.length][3][2];
        for (int i = 0 ; i < prices.length ; ++i) {
            for (int k = 2 ; k >= 1 ; --k) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[0];
                    continue;
                }
                // 当前是第i天，已经交易的次数，并且持有股票
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1]+prices[i]);
                // 当前是第i天，已经交易的次数，不持有股票
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0]-prices[i]);

            }
        }
        return dp[prices.length-1][2][0];
    }

    public static void main(String[] args) {
        int[] price = new int[]{3,3,5,0,0,3,1,4};
        int pri = maxProfit(price);
        System.out.println(pri);

    }
}
