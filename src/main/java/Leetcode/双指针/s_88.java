package Leetcode.双指针;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 13:07 2020/2/15
 * @Modified By:
 */
public class s_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 思路：双指针的思路，一直将较大的数存在num1中，并且需要从后往前存，避免还没有遍历到的数字被覆盖
        int p1 = nums1.length-1;
        m = m-1;
        n = n-1;
        while (m>=0 || n>=0) {
            if (m < 0) {
                nums1[p1] = nums2[n];
                n--;
                p1--;
            } else if (n < 0) {
                m--;
            } else if (nums1[m] >= nums2[n]) {
                nums1[p1] = nums1[m];
                m--;
                p1--;
            } else {
                nums1[p1] = nums2[n];
                n--;
                p1--;
            }
        }
    }
}
