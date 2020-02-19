package Leetcode.贪心;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 11:22 2020/2/19
 * @Modified By:
 */
public class s_53 {
    public int maxSubArray(int[] nums) {
        // 动态规划 f(n)=max(f(n-1)+nums[n], nums[n])
        int max = Integer.MIN_VALUE;
        int f = 0;
        for (int i = 0 ; i < nums.length ; ++i) {
            f = Math.max(f+nums[i], nums[i]);
            max = Math.max(f, max);
        }
        return max;
    }
}
