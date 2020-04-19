package Leetcode.搜索;

import java.util.*;
import java.util.concurrent.SynchronousQueue;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 14:34 2020/2/24
 * @Modified By:
 */
public class m_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 思路：bfs找最短路径，字典中两个单词有一个字母不同则认为这两个单词是连接的，否则不相连。
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.add(beginWord);
        set.add(beginWord);
        int layer = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            layer++;
            for (int i = 0 ; i < size ; ++i) {
                String cur = queue.poll();
                for (String eachWord : wordList) {
                    if (cur.equals(endWord)) {
                        return layer;
                    }
                    if (isNebor(cur, eachWord) && !set.contains(eachWord)) {
                        queue.add(eachWord);
                        set.add(eachWord);
                    }
                }
            }
        }
        return 0;
    }

    public boolean isNebor(String str1, String str2) {
        int flag = 0;
        for (int i = 0 ; i < str1.length() ; ++i) {
            if (str1.charAt(i) != str2.charAt(i)) {
                flag++;
            }
            if (flag > 1) {
                return false;
            }
        }
        return true;
    }
}
