package Leetcode.贪心;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 11:13 2020/2/19
 * @Modified By:
 */
public class s_665 {
    public boolean checkPossibility(int[] nums) {
        // 思路：
        int count = 0;
        for (int i = 0 ; i < nums.length-1 ; ++i) {
            if (nums[i] <= nums[i+1]) {
                continue;
            }
            count++;
            // 3,4,2,3   2,3,3,2,5
            // 分两种情况考虑，一种是当前不满足条件i之前只有一项，还有一种是当前不满足条件i之前还有其他项
            if (nums[i] > nums[i+1]) {
                if (i == 0) {
                    nums[i] = nums[i+1];
                } else if (nums[i+1] < nums[i-1]){
                    nums[i+1] = nums[i];
                }
            }
        }
        return count<=1;
    }
}
