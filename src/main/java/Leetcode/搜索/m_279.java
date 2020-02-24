package Leetcode.搜索;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 13:46 2020/2/24
 * @Modified By:
 */
public class m_279 {
    public int numSquares(int n) {
        // 思路：采用bfs的方式，相当于从n出发，每次减去一个平方数，剩下的数入队列，所以会有多种情况，然后依次出队列，减去一个平方数，直到等于0了就是最短的路径能达到要求的。比如n=12。首先[11,8,3]入队列，因为分别减去了1，2，3的平方数。最后剩下的数依次出队列bfs。。。
        Queue<Integer> queue = new LinkedList<>();
        // 用于去除已经遍历过的点
        Set<Integer> set = new HashSet<>();
        int layer = 0;
        queue.add(n);
        set.add(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            layer++;
            for (int i = 0; i < size; ++i) {
                int val = queue.poll();
                for (int k = 1; val - k * k >= 0; ++k) {
                    if (val - k * k == 0) {
                        return layer;
                    }
                    if (!set.contains(val - k * k)) {
                        set.add(val - k * k);
                        queue.add(val - k * k);
                    }
                }
            }
        }
        return layer;
    }
}
