package Leetcode.排序;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 14:49 2020/2/17
 * @Modified By:
 */
public class m_75 {
    public void sortColors(int[] nums) {
        // 思路是三个指针快排，当是0，则交换到后面，当是1，不变，当是2，交换到前面
        int low = 0, high = nums.length-1;
        int i = 0;
        while (i <= high) {
            if (nums[i] == 0) {
                swap(nums, i, low);
                i++;
                low++;
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, high);
                high--;
            }
        }
    }

    public void swap(int []nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
