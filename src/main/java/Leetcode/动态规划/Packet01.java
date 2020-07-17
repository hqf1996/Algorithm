package Leetcode.动态规划;

/**
 * @Author: hqf
 * @description: 01背包问题
 * @Data: Create in 19:35 2020/4/5
 * @Modified By:
 */
public class Packet01 {
    public static void main(String[] args) {
        // 问题描述，当前有一个容量为W的背包和N个物品，要求装下最高的价值
        // W=12  物品价值数组v = {8, 10, 6, 3, 7, 2}， 物品重量数组w = {4, 6, 2, 2, 5, 1}
        // dp[i][w]表示对于前i个物品，当前背包的容量为w时候的最大价值
        int W = 12;
        int N = 6;
        int[] val = new int[]{0, 8, 10, 6, 3, 7, 2};
        int[] weight = new int[]{0, 4, 6, 2, 2, 5, 1};
        int[][] dp = new int[N+1][W+1];
//        for (int i = 0 ; i <= W ; ++i) {
//            dp[0][i] = 0;
//        }
//        for (int i = 0 ; i <= N ; ++i) {
//            dp[i][0] = 0;
//        }

        for (int i = 1 ; i <= N ; ++i) {
            for (int w = 1 ; w <= W ; ++w) {
                if (weight[i] > w) {
                    dp[i][w] = dp[i-1][w];
                } else {
                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weight[i]]+val[i]);
                }
            }
        }

        for (int i = 0 ; i <= N ; ++i) {
            for (int j = 0 ; j <= W ; ++j) {
                System.out.printf(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
