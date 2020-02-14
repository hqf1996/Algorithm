package Leetcode.双指针;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 18:09 2020/2/14
 * @Modified By:
 */
public class s_633 {
    public boolean judgeSquareSum(int c) {
        // 思路：双指针的思路，只不过目标变成了两数平方和。
        int p1 = 0, p2 = (int)Math.sqrt(c);
        while (p1 <= p2) {
            int sum = p1*p1+p2*p2;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                p2--;
            } else {
                p1++;
            }
        }
        return false;
    }
}
