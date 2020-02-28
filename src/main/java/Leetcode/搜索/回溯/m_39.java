package Leetcode.搜索.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 10:59 2020/2/28
 * @Modified By:
 */
public class m_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 回溯
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        List<Integer> tmp = new ArrayList<>();
        backTracing(candidates, tmp, target, 0, result, 0);
        return result;
    }

    public void backTracing(int[] candidates, List<Integer> tmp, int target, int sum, List<List<Integer>> result, int index) {
        if (sum == target) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index ; i < candidates.length ; ++i) {
            if (sum < target) {
                tmp.add(candidates[i]);
                backTracing(candidates, tmp, target, sum+candidates[i], result, i);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
