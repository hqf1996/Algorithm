package Leetcode.二分查找;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 13:51 2020/2/20
 * @Modified By:
 */
public class m_153 {
    public int findMin(int[] nums) {
        // 思路：二分，找到第一个比后一个数大的数即可
        int low = 0, high = nums.length-1;
        while (low < high) {
            int mid = low+(high-low)/2;
            if (nums[mid]>nums[high]) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
