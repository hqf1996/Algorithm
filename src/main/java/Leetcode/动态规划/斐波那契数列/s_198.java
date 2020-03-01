package Leetcode.动态规划.斐波那契数列;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 16:05 2020/3/1
 * @Modified By:
 */
public class s_198 {
    public int rob(int[] nums) {
        // 抢到第i个住户时的最高金额。dp[i]=max(dp[i-1], dp[i-2]+nums[i])
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2 ; i < nums.length ; ++i) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }
}
