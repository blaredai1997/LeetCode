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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        while (a-- > 1) {
            head = head.next;
            b--;
        }
        ListNode tail = head;
        while (b-- >= 0)
            tail = tail.next;
        head.next = list2;
        while (list2.next != null)
            list2 = list2.next;
        list2.next = tail;
        return list1;
    }
}