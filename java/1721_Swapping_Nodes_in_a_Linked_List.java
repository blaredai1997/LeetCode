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
    public ListNode swapNodes(ListNode head, int k) {
    //     int len = length(head);
    //     int count = 0;
    //     ListNode res = head, node = null;
    //     while (res!=null) {
    //         if (count==(len-k>k-1 ? k-1 : len-k))
    //             node = res;
    //         if (count==(len-k>k-1 ? len-k : k-1)) {
    //             int temp = node.val;
    //             node.val = res.val;
    //             res.val = temp;
    //         }
    //         count++;
    //         res = res.next;
    //     }
    //     return head;
    // }
    // public int length(ListNode head) {
    //     int len = 0;
    //     while (head!=null) {
    //         head = head.next;
    //         len++;
    //     }
    //     return len;
    // }
        ListNode l1 = head, l2 = head, node = null;
        for (int i=0; i<k-1; i++)
            l1 = l1.next;
        node = l1;
        l1 = l1.next;    
        while (l1!=null) {
            l1 = l1.next;
            l2 = l2.next;
        }
        int temp = node.val;
        node.val = l2.val;
        l2.val = temp;
        return head;
    }
}