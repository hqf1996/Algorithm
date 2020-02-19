package Leetcode.二分查找;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 14:25 2020/2/19
 * @Modified By:
 */
public class s_69 {
    public static int mySqrt(int x) {
        // 二分法
        int l = 1, h = x;
        while (l <= h) {
            int mid = l+(h-l)/2;
            int sqrt = x / mid;
            if (mid == sqrt) {
                return mid;
            } else if (mid > sqrt) {
                h = mid-1;
            } else {
                l = mid+1;
            }
        }
        return h;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
}
