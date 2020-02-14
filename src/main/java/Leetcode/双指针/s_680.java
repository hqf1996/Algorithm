package Leetcode.双指针;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 20:11 2020/2/14
 * @Modified By:
 */
public class s_680 {
    public boolean validPalindrome(String s) {
        // 思路：因为是判断是否回文，容易想到双指针的思路，如果前后相同则各自向前一个，如果不同则有两种选择，删除前面的或者后面的，也就是i++或者j--。再判断剩下的字符串是否是回文串。
        char []sChar = s.toCharArray();
        int p1 = 0, p2 = sChar.length-1;
        while (p1 < p2) {
            if (sChar[p1] == sChar[p2]) {
                p1++;
                p2--;
            } else if (sChar[p1] != sChar[p2]) {
                return fun(sChar, p1+1, p2) || fun(sChar, p1, p2-1);
            }
        }
        return true;
    }

    public boolean fun(char []sChar, int p1, int p2) {
        while (p1 < p2) {
            if (sChar[p1] != sChar[p2]) {
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
}
