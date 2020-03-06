package Leetcode.算法设计;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: hqf
 * @description: 基于重写linkedhashmap的removeEldestEntry来移除最晚的一个结点来维持
 * @Data: Create in 15:53 2020/3/6
 * @Modified By:
 */
public class LRU2 extends LinkedHashMap<Integer, Integer> {
    private int cap;
    public LRU2(int cap) {
        super(cap, .75F, true);
        this.cap = cap;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size()>cap;
    }

    public static void main(String[] args) {
        LRU2 lru2 = new LRU2(3);
        lru2.put(1, 1);
        lru2.put(2, 2);
        System.out.println(lru2.get(1));
    }
}
