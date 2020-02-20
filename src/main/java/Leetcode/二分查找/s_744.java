package Leetcode.二分查找;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 11:01 2020/2/20
 * @Modified By:
 */
public class s_744 {
    public char nextGreatestLetter(char[] letters, char target) {
        // 思路：有序->二分查找
        int low = 0, high = letters.length-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (letters[mid] <= target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        if (low < letters.length) {
            return letters[low];
        } else {
            return letters[0];
        }
    }
}
