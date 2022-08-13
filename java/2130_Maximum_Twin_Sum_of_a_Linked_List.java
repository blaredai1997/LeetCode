/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        // ListNode temp = head;
        // int n = 2;
        // while (temp.next.next!=null) {
        //     temp = temp.next.next;
        //     n += 2;
        // }
        // Stack<Integer> stack = new Stack<>();
        // int i;
        // for (i=0; i<=(n/2)-1; i++) {
        //     stack.push(head.val);
        //     head = head.next;
        // }
        // int res = Integer.MIN_VALUE;
        // while (i<n) {
        //     int val = stack.pop();
        //     res = Math.max(res, val+head.val);
        //     head = head.next;
        //     i++;
        // }
        // return res;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while (fast!=null) {
            fast = fast.next.next;
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        int res = Integer.MIN_VALUE;
        while (slow!=null && prev!=null) {
            res = Math.max(res, slow.val+prev.val);
            slow = slow.next;
            prev = prev.next;
        }
        return res;
    }
}