package Leetcode.搜索.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 10:34 2020/2/28
 * @Modified By:
 */
public class m_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 回溯
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        List<Integer> tmp = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, tmp, flag, result);
        return result;
    }

    public void dfs(int[] nums, List<Integer> tmp, boolean[] flag, List<List<Integer>> result) {
        if (tmp.size()==nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0 ; i < nums.length ; ++i) {
            // 剪枝
            if (i>0 && nums[i]==nums[i-1] && flag[i-1]==false) {
                continue;
            }
            if (flag[i] == false) {
                tmp.add(nums[i]);
                flag[i] = true;
                dfs(nums, tmp, flag, result);
                tmp.remove(tmp.size()-1);
                flag[i] = false;
            }
        }
    }
}
