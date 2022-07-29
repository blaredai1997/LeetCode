/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // if (head==null) return null;
        // Node copy = new Node(head.val), res = copy;
        // Node h = head, c = copy;
        // Map<Node, Node> map = new HashMap<>();
        // map.put(head, copy);
        // while (head.next!=null) {
        //     head = head.next;
        //     copy.next = new Node(head.val);
        //     copy = copy.next;
        //     map.put(head, copy);
        // }
        // while (h!=null) {
        //     if (h.random!=null)
        //         c.random = map.get(h.random);
        //     h = h.next;
        //     c = c.next;
        // }
        // return res;
        if (head==null) return null;
        Node h = head;
        while (h!=null) {
            Node n = new Node(h.val);
            n.next = h.next;
            h.next = n;
            h = n.next;
        }
        h = head;
        while (h!=null) {
            h.next.random = (h.random==null) ? null : h.random.next;
            h = h.next.next;
        }
        Node OLD = head;
        Node NEW = head.next;
        Node res = head.next;
        while (OLD!=null) {
            OLD.next = OLD.next.next;
            NEW.next = (NEW.next==null) ? null : NEW.next.next;
            OLD = OLD.next;
            NEW = NEW.next;
        }
        return res;
    }
}