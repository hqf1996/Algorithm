package Leetcode.搜索.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hqf
 * @description: 回溯法的模板要牢记
 * @Data: Create in 13:50 2020/2/26
 * @Modified By:
 */
public class m_17 {
//    public List<String> letterCombinations(String digits) {
//        // dfs 回溯法的套路
//        String[] pattern = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//        List<String> result = new ArrayList<>();
//        if (digits.equals("")) {
//            return result;
//        }
//        backTracing(new StringBuilder(), digits, pattern, result);
//        System.out.println(result);
//        return result;
//    }
//
//    public void backTracing(StringBuilder sb, String digits, String[] pattern, List<String> result) {
//        if (sb.length() == digits.length()) {
//            result.add(sb.toString());
//            return;
//        }
//        String p = pattern[digits.charAt(sb.length()) - '0'];
//        for (char each : p.toCharArray()) {
//            sb.append(each);
//            backTracing(sb, digits, pattern, result);
//            sb.deleteCharAt(sb.length()-1);
//        }
//    }

    public List<String> letterCombinations(String digits) {
        // 也可以用普通的dfs去做，不用考虑回溯
        String[] pattern = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        if (digits.equals("")) {
            return result;
        }
        backTracing("", digits, pattern, result);
        return result;
    }

    public void backTracing(String sb, String digits, String[] pattern, List<String> result) {
        if (sb.length() == digits.length()) {
            System.out.println(sb);
            result.add(sb);
            return;
        }
        System.out.println(sb);
        String p = pattern[digits.charAt(sb.length()) - '0'];
        for (char each : p.toCharArray()) {
//            sb = sb+each;
//            backTracing(sb, digits, pattern, result);
//            sb = sb.substring(0, sb.length()-1);
            // 上下两种写法一样
            backTracing(sb+each, digits, pattern, result);
        }
    }

    public static void main(String[] args) {
        m_17 m = new m_17();
        m.letterCombinations("23");
    }
}
