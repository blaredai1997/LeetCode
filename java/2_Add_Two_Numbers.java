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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0), head = res;
        int passOne = 0;
        while (l1!=null || l2!=null) {
            int v1 = (l1!=null) ? l1.val : 0;
            int v2 = (l2!=null) ? l2.val : 0;
            int value = v1 + v2 + passOne;
            passOne = value/10;
            res.next = new ListNode(value%10);
            if (l1!=null)
                l1 = l1.next;
            if (l2!=null)
                l2 = l2.next;
            res = res.next;
        }
        if (passOne>0)
            res.next = new ListNode(1);
        return head.next;
    }
}