package Leetcode.双指针;

import java.util.List;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 13:57 2020/2/15
 * @Modified By:
 */
public class m_524 {
    public String findLongestWord(String s, List<String> d) {
        //思路，依次用双指针法单个匹配字符串即可。
        String resultStr = "";
        if (s.length()==0 || d.size()==0) {
            return resultStr;
        }
        int sLength = s.length();
        for (String target : d) {
            int targetLength = target.length();
            if (sLength < targetLength) {
                continue;
            }
            int p1 = 0, p2 = 0;
            while (p1<sLength && p2<targetLength) {
                if (s.charAt(p1) == target.charAt(p2)) {
                    p2++;
                }
                p1++;
            }
            // 返回最长的字符串
            if (p2 == targetLength) {
                if (resultStr.equals("") || resultStr.length()<target.length()
                        || (resultStr.length()==target.length() && resultStr.compareTo(target)>0)) {
                    resultStr = target;
                }
            }
        }
        return resultStr;
    }
}
