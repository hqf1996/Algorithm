package Leetcode.动态规划.斐波那契数列;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 16:46 2020/3/1
 * @Modified By:
 */
public class m_213 {
    public int rob(int[] nums) {
        // 这么去考虑：第1户和最后一户不能同时抢。不抢最后一户最大：只抢1到n-1。不抢第一户：只抢2到n。最后取最大值。
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(fun(nums, 0, nums.length-2), fun(nums, 1, nums.length-1));
    }

    public int fun(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start+1]);
        for (int i = 2 ; i <= end-start ; ++i) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i+start]);
        }
        return dp[end-start];
    }
}
