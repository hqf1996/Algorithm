package Leetcode.链表;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 20:40 2020/6/22
 * @Modified By: 链表反转，递归和非递归都要会实现，很重要。
 */
public class s_206 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseList(ListNode head) {
        /**迭代
         ListNode cur = head;
         ListNode pre = null;
         while (cur != null) {
         ListNode next = cur.next;
         cur.next = pre;
         pre = cur;
         cur = next;
         }
         return pre;**/
        /**递归*/
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
}
