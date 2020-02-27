package Leetcode.搜索.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 15:23 2020/2/27
 * @Modified By:
 */
public class m_77 {
    public List<List<Integer>> combine(int n, int k) {
        // 回溯
        List<List<Integer>> result = new ArrayList<>();
        if (k == 0 || n<k) {
            return result;
        }
        List<Integer> tmp = new ArrayList<>();
        backTracing(n, k, result, tmp, 1);
        return result;
    }

    public void backTracing(int n, int k, List<List<Integer>> result, List<Integer> tmp, int index) {
        if (tmp.size() == k) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        // 可以进行剪枝，比如n=4,k=2。这边的i就不需要取到4了，因为即使取到了也不能再添加进一个元素了。
        for (int i = index ; i <= n-(k-tmp.size())+1 ; ++i) {
            tmp.add(i);
            backTracing(n, k, result, tmp, i+1);
            tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] args) {
        m_77 m = new m_77();
        m.combine(3, 3);
    }
}
