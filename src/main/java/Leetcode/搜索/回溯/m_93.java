package Leetcode.搜索.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 16:05 2020/2/26
 * @Modified By:
 */
public class m_93 {
    public List<String> restoreIpAddresses(String s) {
        // 回溯法
        List<String> result = new ArrayList<>();
        if (s.equals("")) {
            return result;
        }
        backTracing(s, result, new StringBuilder(), 0);
        return result;
    }

    public void backTracing(String s, List<String> result, StringBuilder sb, int k) {
        // k表示当前已经有4段了，并且剩下的字符串为空的时候说明是一个结果
        if (k == 4 || s.length()==0) {
            if (k == 4 && s.length()==0) {
                result.add(sb.toString());
            }
            return;
        }
        for (int i = 0 ; i<3 && i<s.length() ; ++i) {
            String tmp = s.substring(0, i+1);
            // 01这种超过一位的不能以0开头
            if (s.charAt(0) == '0' && tmp.length()>1) {
                continue;
            }
            // 超过255也不行
            if (Integer.valueOf(tmp)>255) {
                continue;
            }
            if (sb.length()>0) {
                sb.append(".").append(tmp);
                backTracing(s.substring(i+1), result, sb, k+1);
                sb.delete(sb.length()-tmp.length()-1, sb.length());
            } else {
                sb.append(tmp);
                backTracing(s.substring(i+1), result, sb, k+1);
                sb.delete(sb.length()-tmp.length(), sb.length());
            }
        }
    }
}
