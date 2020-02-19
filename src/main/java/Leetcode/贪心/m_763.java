package Leetcode.贪心;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 13:05 2020/2/19
 * @Modified By:
 */
public class m_763 {
    public List<Integer> partitionLabels(String S) {
        // 思路：一开始想到的思路是转换为首先出现字母和最后出现字母的区间，然后求不重复区间的数量即可，但是这样会比较耗时一点。
        // 后面采用存在map中先，然后根据第一个字母开始设定界限，如果还没有超过界限，则继续下一个字母，如果超过界限则更新界限。
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0 ; i < S.length() ; ++i) {
            map.put(S.charAt(i), i);
        }
        ArrayList<Integer> result = new ArrayList<>();
        int curP = 0;
        while (curP < S.length()) {
            int limit = map.get(S.charAt(curP));
            for (int k = curP ; k < limit ; k++) {
                if (map.get(S.charAt(k)) <= limit) {
                    continue;
                } else {
                    limit = map.get(S.charAt(k));
                }
            }
            result.add(limit-curP+1);
            curP = limit+1;
        }
        return result;
    }
}
