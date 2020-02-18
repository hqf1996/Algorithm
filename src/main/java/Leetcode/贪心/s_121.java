package Leetcode.贪心;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 13:35 2020/2/18
 * @Modified By:
 */
public class s_121 {
    public int maxProfit(int[] prices) {
        // 记录当前的最小值和最大收益
        if (prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int maxGet = 0;
        for (int i = 1 ; i < prices.length ; ++i) {
            if ((prices[i] - min) > maxGet) {
                maxGet = prices[i] - min;
            }
            if (min > prices[i]) {
                min = prices[i];
            }
        }
        return maxGet;
    }
}
