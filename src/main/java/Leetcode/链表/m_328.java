package Leetcode.链表;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 21:01 2020/6/30
 * @Modified By:
 */
public class m_328 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode everyNode = p2;
        while (head.next != null && everyNode.next != null) {
            head.next = everyNode.next;
            head = head.next;
            everyNode.next = head.next;
            everyNode = everyNode.next;
        }
        head.next = p2;
        return p1;
    }
}
