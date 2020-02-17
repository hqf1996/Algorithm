package Leetcode.贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 15:26 2020/2/17
 * @Modified By:
 */
public class s_455 {
    public int findContentChildren(int[] g, int[] s) {
        // 贪心策略：给小胃口的喂最小的但是能满足的饼干即可，就能让尽可能多的人吃到饼干
        Arrays.sort(g);
        Arrays.sort(s);
        int p1 = 0, p2 = 0;
        int nums = 0;
        while (p1 < g.length && p2 < s.length) {
            if (g[p1] <= s[p2]) {
                nums++;
                p1++;
                p2++;
            } else {
                p2++;
            }
        }
        return nums;
    }
}

