package Leetcode.贪心;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 13:41 2020/2/18
 * @Modified By:
 */
public class s_122 {
    public int maxProfit(int[] prices) {
        // 把所有增长的每一小段加起来即可
        int max = 0;
        for (int i = 0 ; i < prices.length-1 ; ++i) {
            if (prices[i+1]-prices[i] > 0) {
                max+=(prices[i+1]-prices[i]);
            }
        }
        return max;
    }
}
