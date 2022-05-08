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
        // ListNode head = null;
        // Stack<Integer> s1 = new Stack<>();
        // Stack<Integer> s2 = new Stack<>();
        // while (l1!=null) {
        //     s1.push(l1.val);
        //     l1 = l1.next;
        // }
        // while (l2!=null) {
        //     s2.push(l2.val);
        //     l2 = l2.next;
        // }
        // int value = 0;
        // while (!s1.isEmpty() || !s2.isEmpty() || value!=0) {
        //     value += (!s1.isEmpty() ? s1.pop() : 0) + (!s2.isEmpty() ? s2.pop() : 0);
        //     ListNode res = new ListNode(value%10);
        //     res.next = head;
        //     head = res;
        //     value /= 10;
        // }
        // return head;
        int len1 = length(l1);
        int len2 = length(l2);
        ListNode res = null, head = null;
        while (l1!=null && l2!=null) {
            int v1 = 0, v2 = 0;
            if (len1>=len2) {
                v1 = l1.val;
                l1 = l1.next;
                len1--;
            }
            if (len2>=len1+1) {
                v2 = l2.val;
                l2 = l2.next;
                len2--;
            }
            res = new ListNode(v1+v2);
            res.next = head;
            head = res;
        }
        int passOne = 0;
        head = null;
        while (res!=null) {
            int value = res.val + passOne;
            res.val = value%10;
            passOne = value/10;
            ListNode temp = res.next;
            res.next = head;
            head = res;
            res = temp;
        }
        if (passOne>0) {
            res = new ListNode(1);
            res.next = head;
            head = res;
        }
        return head;
    }
    public int length(ListNode l) {
        int len = 0;
        while (l!=null) {
            l = l.next;
            len++;
        }
        return len;
    }
}