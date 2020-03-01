package Leetcode.动态规划.斐波那契数列;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 14:51 2020/3/1
 * @Modified By:
 */
public class s_70 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        /***
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3 ; i <= n ; ++i) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n];
         **/
        int p1 = 1;
        int p2 = 2;
        for (int i = 3 ; i <=n ; ++i) {
            int tmp = p1+p2;
            p1 = p2;
            p2 = tmp;
        }
        return p2;
    }
}
