package Leetcode.贪心;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 14:54 2020/2/18
 * @Modified By:
 */
public class s_392 {
    public boolean isSubsequence(String s, String t) {
        // 双指针问题
        int p1 = 0, p2 = 0;
        while (p1 < s.length() && p2 < t.length()) {
            if (s.charAt(p1)==t.charAt(p2)) {
                p1++;
            }
            p2++;
        }
        return p1==s.length();
    }
}
