package Leetcode.二分查找;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 14:51 2020/2/20
 * @Modified By:
 */
public class m_34 {
    public static int[] searchRange(int[] nums, int target) {
        // 思路：二分查找
        // 查找左边界
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int low = 0, high = nums.length-1;
        while (low < high) {
            int mid = low + (high - low)/2;
            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        int left = low;
        if (nums[low] != target) {
            return new int[]{-1, -1};
        }
        // 查找右边界，这边判断的是target+1，而不是target，并且
        low = 0;
        high = nums.length;
        while (low < high) {
            int mid = low + (high - low)/2;
            if (nums[mid] >= target+1) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{left, low-1};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        searchRange(nums, 8);
    }
}
