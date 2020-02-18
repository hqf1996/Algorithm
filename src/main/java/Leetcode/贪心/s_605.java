package Leetcode.贪心;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 14:37 2020/2/18
 * @Modified By:
 */
public class s_605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 相当于当两个边界值中有0的时候，在其前面或者后面填上0，避免处理边界的情况。
        int num = 0;
        for (int i = 0 ; i < flowerbed.length ; ++i) {
            if (flowerbed[i] ==  1) {
                continue;
            }
            int pre = i == 0 ? 0 : flowerbed[i-1];
            int next = i == flowerbed.length-1 ? 0 : flowerbed[i+1];
            if (pre == 0 && next == 0) {
                flowerbed[i] = 1;
                num++;
            }
        }
        return num>=n;
    }
}
