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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = head, rev = null;
        for (int i=0; i<left-1; i++) {
            rev = res;
            res = res.next;
        }
        ListNode resHead = rev, tail = res;
        for (int i=left-1; i<=right-1; i++) {
            if (res!=null) {
                ListNode temp = res.next;
                res.next = rev;
                rev = res;
                res = temp;
            }
        }
        if (resHead!=null)
            resHead.next = rev;
        else
            head = rev;
        tail.next = res;
        return head;
    }
}