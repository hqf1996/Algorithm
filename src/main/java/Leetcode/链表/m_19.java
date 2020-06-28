package Leetcode.链表;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 21:16 2020/6/23
 * @Modified By:
 */
public class m_19 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preNode = new ListNode(-1);
        preNode.next = head;
        ListNode p1 = preNode;
        ListNode p2 = head;
        for (int i = 0 ; i < n ; ++i) {
            p2 = p2.next;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return preNode.next;
    }
}
