package Leetcode.二分查找;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 13:33 2020/2/20
 * @Modified By:
 */
public class s_278 {
    public boolean isBadVersion(int i) {
        /**
         * 判断是否是错误版本*/

        return false;
    }

    public int firstBadVersion(int n) {
        // 思路：二分
        int low = 1, high = n;
        while (low < high) {
            int mid = low + (high-low)/2;
            if (!isBadVersion(mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
