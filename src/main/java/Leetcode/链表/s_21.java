package Leetcode.链表;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 21:01 2020/6/22
 * @Modified By:
 */
public class s_21 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /**递归解法
         if (l1 == null) {
         return l2;
         }
         if (l2 == null) {
         return l1;
         }
         if (l1.val < l2.val) {
         l1.next = mergeTwoLists(l1.next, l2);
         return l1;
         } else {
         l2.next = mergeTwoLists(l1, l2.next);
         return l2;
         }**/
        /**非递归解法**/
        // 引入虚节点
        ListNode preNode = new ListNode(-1);
        ListNode p = preNode;
        while (l1!=null && l2!=null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1==null?l2:l1;
        return preNode.next;
    }
}
