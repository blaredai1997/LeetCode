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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for (ListNode node : lists)
            if (node!=null)
                pq.offer(node);
        ListNode head = new ListNode(0), res = head;
        while (!pq.isEmpty()) {
            head.next = pq.poll();
            head = head.next;
            if (head.next!=null) pq.offer(head.next);
        }
        return res.next;
    }
}