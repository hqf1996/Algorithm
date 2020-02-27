package Leetcode.搜索.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 13:38 2020/2/27
 * @Modified By:
 */
public class m_46 {
    public List<List<Integer>> permute(int[] nums) {
        // dfs+回溯
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        List<Integer> tmp = new ArrayList<>();
        backTracing(nums, result, tmp);
        return result;
    }

    public void backTracing(int[] nums, List<List<Integer>> result, List<Integer> tmp) {
        if (tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0 ; i < nums.length ; ++i) {
            if (!tmp.contains(nums[i])) {
                tmp.add(nums[i]);
                backTracing(nums, result, tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
