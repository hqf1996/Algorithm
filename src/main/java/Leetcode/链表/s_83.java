package Leetcode.链表;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 21:49 2020/6/22
 * @Modified By:
 */
public class s_83 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode next = head;
        while (cur != null) {
            while (next != null && cur.val == next.val) {
                next = next.next;
            }
            cur.next = next;
            cur = cur.next;
        }
        return head;
    }
}
