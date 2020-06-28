package Leetcode.链表;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 21:54 2020/6/28
 * @Modified By:
 */
public class m_234 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean isPalindrome(ListNode head) {
        // 快慢指针找到中间点，然后后面链表翻转，再从头比较
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 从slow的后一个开始截取并反转
        ListNode reveL = reverse(slow.next);
        while(reveL != null) {
            if (head.val != reveL.val) {
                return false;
            }
            head = head.next;
            reveL = reveL.next;
        }
        return true;
    }

    public ListNode reverse(ListNode L) {
        ListNode cur = L;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
