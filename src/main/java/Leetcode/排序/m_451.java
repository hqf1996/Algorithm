package Leetcode.排序;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 13:58 2020/2/17
 * @Modified By:
 */
public class m_451 {
    public String frequencySort(String s) {
        // 思路:桶排序，把出现的频率当成下标
        char []sChar = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : sChar) {
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c)+1);
            }
        }
        // 放入桶中
        ArrayList<Character>[] buckets = new ArrayList[s.length()+1];
        for (char each : map.keySet()) {
            int index = map.get(each);
            if (buckets[index] == null) {
                buckets[index] = new ArrayList<>();
            }
            buckets[index].add(each);
        }
        // 打印桶元素
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length-1 ; i >= 0 ; --i) {
            if (buckets[i] != null) {
                for (int j = 0 ; j < buckets[i].size() ; ++j) {
                    for (int k = 0 ; k < i ; ++k) {
                        sb.append(buckets[i].get(j));
                    }
                }
            }
        }
        return new String(sb);
    }
}
