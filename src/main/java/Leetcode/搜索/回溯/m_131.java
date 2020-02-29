package Leetcode.搜索.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 10:17 2020/2/29
 * @Modified By:
 */
public class m_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s.equals("")) {
            return result;
        }
        List<String> tmp = new ArrayList<>();
        backTracing(s, result, tmp);
        return result;
    }

    public void backTracing(String s, List<List<String>> result, List<String> tmp) {
        if (s.length() == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0 ; i < s.length() ; ++i) {
            if (isHuiwen(s, 0, i)) {
                tmp.add(s.substring(0, i+1));
                backTracing(s.substring(i+1), result, tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    public boolean isHuiwen(String s, int start, int end) {
        int p1 = start, p2 = end;
        while(p1 <= p2) {
            if (s.charAt(p1) != s.charAt(p2)) {
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
}
