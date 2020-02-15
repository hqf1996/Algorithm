package Leetcode.双指针;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 13:31 2020/2/15
 * @Modified By:
 */
public class s_141 {
     class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
     }

    public boolean hasCycle(ListNode head) {
        // 思路：这道题在牛课上做过，当时的思路是用一个set去存遍历过的结点，一旦有重复的话就说明有环，这样的话就有空间的消耗。另外一个思路是用快慢指针来做，一个指针每次只向前进一个，一个指针每次向前走两步，如果能相遇，则说明有环。
        if (head == null) {
            return false;
        }
        ListNode p1 = head; //慢指针
        ListNode p2 = head; //快指针
        while (p1 != null && p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }
}
