package Leetcode.双指针;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 18:14 2020/2/14
 * @Modified By:
 */
public class s_345 {
    public String reverseVowels(String s) {
        // 思路：双指针的思路，指针位置不同，则交换两个字符，若指针位置相同则不交换
        if (s.length() == 0) {
            return s;
        }
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        char []sChar = s.toCharArray();
        int p1 = 0, p2 = sChar.length-1;
        while (p1 <= p2) {
            char tmp1 = sChar[p1];
            char tmp2 = sChar[p2];
            if (!set.contains(tmp1)) {
                p1++;
            } else if (!set.contains(tmp2)) {
                p2--;
            } else {
                sChar[p1] = tmp2;
                sChar[p2] = tmp1;
                p1++;
                p2--;
            }
        }
        return new String(sChar);
    }
}
