package Leetcode.jianzhiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 11:59 2020/3/11
 * @Modified By:
 */
public class t4 {
     public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(0, head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        int i = 0;
        for(int each : list) {
            res[i++] = each;
        }
        return res;
    }
}
