package Leetcode.排序;

import java.util.*;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 10:53 2020/2/17
 * @Modified By:
 */
public class m_347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 思路：首先想到的是用hashmap来存储，然后用小根堆获得topK个大的value即可。还有一种方法是桶排序的方法获得topK个。

        // hashmap方法
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer each : nums) {
            if (map.get(each) == null) {
                map.put(each, 1);
            } else {
                map.put(each, map.get(each)+1);
            }
        }
        // 获得topK个大，创建小根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(a)-map.get(b));
        for (Map.Entry<Integer, Integer> each : map.entrySet()) {
            if (queue.size() < k) {
                queue.add(each.getKey());
            } else {
                if (map.get(queue.peek()) < each.getValue()) {
                    queue.poll();
                    queue.add(each.getKey());
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        return list;

        // 桶排序，桶的下标代表出现的频率
        /**
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer each : nums) {
            if (map.get(each) == null) {
                map.put(each, 1);
            } else {
                map.put(each, map.get(each)+1);
            }
        }
        ArrayList<Integer>[] list = new ArrayList[nums.length+1];
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            if (list[value] == null) {
                list[value] = new ArrayList<>();
            }
            list[value].add(key);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = nums.length ; i>=0 && result.size()<k ; --i) {
            if (list[i] != null) {
                result.addAll(list[i]);
            }
        }
        return result;**/
    }
}
