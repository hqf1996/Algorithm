package Leetcode.搜索.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 13:19 2020/2/28
 * @Modified By:
 */
public class m_78 {
    public List<List<Integer>> subsets(int[] nums) {
        // 回溯
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        backTracing(nums, result, tmp, 0);
        return result;
    }

    public void backTracing(int[]nums, List<List<Integer>> result, List<Integer> tmp, int index) {
        result.add(new ArrayList<>(tmp));
        for (int i = index ; i < nums.length ; ++i) {
            tmp.add(nums[i]);
            backTracing(nums, result, tmp, i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}
