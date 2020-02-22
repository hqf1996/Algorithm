package Leetcode.分治_递归;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 13:52 2020/2/22
 * @Modified By:
 */
public class m_241 {
    public List<Integer> diffWaysToCompute(String input) {
        // 递归+分治
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0 ; i < input.length() ; ++i) {
            char cur = input.charAt(i);
            if (cur == '+' || cur == '-' || cur == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for (int l : left) {
                    for (int r : right) {
                        if (cur == '+') {
                            result.add(l + r);
                        } else if (cur == '-') {
                            result.add(l - r);
                        } else if (cur == '*') {
                            result.add(l * r);
                        }
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }
        return result;
    }
}
