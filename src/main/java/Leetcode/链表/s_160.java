package Leetcode.链表;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 19:39 2020/6/22
 * @Modified By: 找到相交的点，浪漫解法233
 */
public class s_160 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 从两端出发，走到末尾之后就从另一端开始走，最终会相交
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }
}
