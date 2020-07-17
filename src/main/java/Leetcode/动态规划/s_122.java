package Leetcode.动态规划;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 21:20 2020/7/17
 * @Modified By:
 */
public class s_122 {
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0 ; i < prices.length-1 ; ++i) {
            if (prices[i+1]>prices[i]) {
                result += (prices[i+1]-prices[i]);
            }
        }
        return result;
    }
}
