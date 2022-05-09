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
    public ListNode swapPairs(ListNode head) {
        // ListNode resHead = new ListNode();
        // resHead.next = head;
        // ListNode res = resHead;
        // while (res.next!=null && res.next.next!=null) {
        //     ListNode temp1 = res.next;
        //     ListNode temp2 = res.next.next;
        //     temp1.next = temp2.next;
        //     res.next = temp2;
        //     res.next.next = temp1;
        //     res = res.next.next;
        // }
        // return resHead.next;
        if (head==null || head.next==null)
            return head;
        ListNode temp1 = head.next;
        ListNode temp2 = temp1.next;
        temp1.next = head;
        head.next = swapPairs(temp2);
        return temp1;
    }
}