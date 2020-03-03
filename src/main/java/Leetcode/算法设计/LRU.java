package Leetcode.算法设计;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: hqf
 * @description: 用HashMap和双向链表实现一个LRU算法（最近最少使用算法）
 * @Data: Create in 16:02 2020/3/3
 * @Modified By:
 */
public class LRU {
    /**
     * 双向链表的结点
     */
    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }

    /**
     * 双向链表
     */
    class DoubleList {
        // 链表的头和尾
        Node head, tail;
        // 链表的容量
        int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        // 在链表头部添加结点
        public void addHeadNode(Node node) {
            node.next = head.next;
            head.next.pre = node;
            node.pre = head;
            head.next = node;
            size++;
        }

        // 删除链表中的一个已经存在的结点
        public void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        // 删除链表中最后一个结点并返回
        public Node removeLast() {
            if (head.next == tail) {
                return null;
            }
            Node node = tail.pre;
            remove(node);
            return node;
        }

        // 返回链表长度
        public int getSize() {
            return size;
        }
    }

    DoubleList doubleList;
    Map<Integer, Node> map;
    int cap;

    public LRU(int cap) {
        this.cap = cap;
        doubleList =  new DoubleList();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).value;
        System.out.println(val);
        put(key, val);
        return val;
    }

    public void put(int key, int val) {
        // 创建这个结点
        Node node = new Node(key, val);
        if (map.containsKey(key)) {
            doubleList.remove(map.get(key));
            doubleList.addHeadNode(node);
            map.put(key, node);  //要更新，因为要考虑比如说(2,1)(2,2)的情况，更新成最新的node
        } else {
            // 已经满了
            if (cap == doubleList.size) {
                Node lastNode = doubleList.removeLast();
                map.remove(lastNode.key);
            }
            doubleList.addHeadNode(node);
            map.put(key, node);
        }
    }

    public static void main(String[] args) {
        LRU lru = new LRU(3);
        lru.put(2, 1);
        lru.put(2, 2);
        lru.get(2);
    }
}
