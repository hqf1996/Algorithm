package Leetcode.双指针;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 18:02 2020/2/14
 * @Modified By:
 */
public class s_167 {
    public int[] twoSum(int[] numbers, int target) {
        // 思路是设定两个指针，一个从头往后，一个从后往前，如果之和大于目标，则尾指针左移。如果小于，头指针往后
        if (numbers.length == 0) {
            return null;
        }
        int p1 = 0, p2 = numbers.length-1;
        int []result = new int[2];
        while (p1<p2) {
            int sum = numbers[p1]+numbers[p2];
            if (sum == target) {
                result[0] = p1+1;
                result[1] = p2+1;
                return result;
            } else if (sum > target) {
                p2--;
            } else {
                p1++;
            }
        }
        return null;
    }
}
