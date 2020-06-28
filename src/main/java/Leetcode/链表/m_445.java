package Leetcode.链表;

import java.util.List;
import java.util.Stack;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 21:02 2020/6/28
 * @Modified By:
 */
public class m_445 {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 放在两个栈中，然后头插法
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int flag = 0; // 标记进位
        ListNode preNode = new ListNode(-1);
        while(!stack1.isEmpty() || !stack2.isEmpty() || flag>0) {
            int val1 = 0;
            int val2 = 0;
            if (!stack1.isEmpty()) {
                val1 = stack1.pop();
            }
            if (!stack2.isEmpty()) {
                val2 = stack2.pop();
            }
            int sum = val1+val2+flag;
            ListNode node = new ListNode(sum%10);
            node.next = preNode.next;
            preNode.next = node;
            if (sum >= 10) {
                flag = 1;
            }
        }
        return preNode.next;
    }
}
