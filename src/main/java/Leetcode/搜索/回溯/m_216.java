package Leetcode.搜索.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 13:13 2020/2/28
 * @Modified By:
 */
public class m_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        // 回溯
        List<List<Integer>> result = new ArrayList<>();
        if (k==0 || n==0) {
            return result;
        }
        List<Integer> tmp = new ArrayList<>();
        backTracing(k, n, tmp, result, 1);
        return result;
    }

    public void backTracing(int k, int n, List<Integer> tmp, List<List<Integer>> result, int index) {
        if (n == 0 && tmp.size() == k) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        if (tmp.size() == k) {
            return;
        }
        for (int i = index ; i <= 9 ; ++i) {
            if (n>=i && tmp.size()<k) {
                tmp.add(i);
                backTracing(k, n-i, tmp, result, i+1);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
