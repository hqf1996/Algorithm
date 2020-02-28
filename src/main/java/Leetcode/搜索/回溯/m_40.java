package Leetcode.搜索.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 11:11 2020/2/28
 * @Modified By:
 */
public class m_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        List<Integer> tmp = new ArrayList<>();
        boolean[] flag = new boolean[candidates.length];
        Arrays.sort(candidates);
        backTracing(candidates, target, tmp, result, 0, flag);
        return result;
    }

    public void backTracing(int[] candidates, int target, List<Integer> tmp, List<List<Integer>> result, int index, boolean[] flag) {
        if (target == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index ; i < candidates.length ; ++i) {
            if (i>0 && candidates[i-1]==candidates[i] && flag[i-1]==false) {
                continue;
            }
            if (target>0 && candidates[i]<=target) {
                tmp.add(candidates[i]);
                flag[i] = true;
                backTracing(candidates, target-candidates[i], tmp, result, i+1, flag);
                flag[i] = false;
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
