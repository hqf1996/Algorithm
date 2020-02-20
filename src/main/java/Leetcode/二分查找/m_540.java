package Leetcode.二分查找;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 13:01 2020/2/20
 * @Modified By:
 */
public class m_540 {
    public int singleNonDuplicate(int[] nums) {
        // 思路：可用位运算，但是时间复杂度会在O(n)。又由于其是有序数组，考虑二分。
        int low = 0, high = nums.length-1;
        while (low < high) {
            int mid = low+(high-low)/2;
            // 一奇一偶可以看成一对数对，如果当前m是奇数，则应该m-1与它相等。如果当前m是偶数，则应该m+1与它相等。相等则说明m之前的这段数字中还没有破坏这个规律，单独的这个数在后半段。否则，则已经破坏了规律，单独的这个数在前半段。
            if (mid % 2 == 1) {
                if (nums[mid] == nums[mid-1]) {
                    low = mid+1;
                } else {
                    high = mid;
                }
            } else {
                if (nums[mid] == nums[mid+1]) {
                    low = mid+1;
                } else {
                    high = mid;
                }
            }
        }
        return nums[low];
    }
}
