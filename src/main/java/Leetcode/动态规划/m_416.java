package Leetcode.动态规划;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 20:33 2020/6/17
 * @Modified By:
 */
public class m_416 {
    public boolean canPartition(int[] nums) {
        // 可以看成背包容量为sum/2的01背包问题
        int sum = 0;
        for (int i = 0 ; i < nums.length ; ++i) {
            sum += nums[i];
        }
        // 奇数直接退出
        if (sum % 2 == 1) {
            return false;
        }
        int n = sum / 2;  // 背包容量
        boolean[][] dp = new boolean[nums.length][n+1];  // dp[i][w]=true代表前i个数之和为w
        if (nums[0] == n) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1 ; i < nums.length ; ++i) {
            for (int w = 0 ; w <= n ; ++w) {
                if (nums[i] == w) {
                    dp[i][w] = true;
                    continue;
                }
                if (nums[i] < w) {
                    dp[i][w] = dp[i-1][w] || dp[i-1][w-nums[i]];
                }
            }
        }
        return dp[nums.length-1][n];
    }

    /*** 压缩的01背包
     * public boolean canPartition(int[] nums) {
     *         // 可以看成背包容量为sum/2的01背包问题
     *         int sum = 0;
     *         for (int i = 0 ; i < nums.length ; ++i) {
     *             sum += nums[i];
     *         }
     *         // 奇数直接退出
     *         if (sum % 2 == 1) {
     *             return false;
     *         }
     *         int n = sum / 2;  // 背包容量
     *         boolean[] dp = new boolean[n+1];  // dp[i][w]=true代表前i个数之和为w
     *         dp[0] = true;
     *         for (int num : nums) {
     *             for (int i = n ; i >= num ; --i) {
     *                 dp[i] = dp[i] || dp[i-num];
     *             }
     *         }
     *         return dp[n];
     *     }
     */
}
