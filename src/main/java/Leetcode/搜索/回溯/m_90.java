package Leetcode.搜索.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 13:29 2020/2/28
 * @Modified By:
 */
public class m_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        Arrays.sort(nums);
        backTracing(nums, tmp, result, 0, flag);
        return result;
    }

    public void backTracing(int[] nums, List<Integer> tmp, List<List<Integer>> result, int index, boolean[] flag) {
        result.add(new ArrayList<>(tmp));
        for (int i = index ; i < nums.length ; ++i) {
            if (i>0 && nums[i-1]==nums[i] && flag[i-1]==false) {
                continue;
            }
            tmp.add(nums[i]);
            flag[i] = true;
            backTracing(nums, tmp, result, i+1, flag);
            flag[i] = false;
            tmp.remove(tmp.size()-1);
        }
    }
}
