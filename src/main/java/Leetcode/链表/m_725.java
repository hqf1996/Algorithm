package Leetcode.链表;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 0:25 2020/6/29
 * @Modified By:
 */
public class m_725 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode p = root;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        int everyLen = len / k;
        int lefLen = len - everyLen*k;
        int count = 0;
        ListNode cur = root;
        ListNode[] lists = new ListNode[k];
        for (int i = 0 ; i < k && cur!=null ; ++i) {
            int curSize = lefLen>0?everyLen+1:everyLen;
            lefLen--;
            lists[i] = cur;
            for (int j = 0 ; j < curSize-1 ; ++j) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return lists;
    }
}
