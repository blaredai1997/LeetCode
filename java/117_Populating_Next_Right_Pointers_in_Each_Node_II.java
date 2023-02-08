/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        // if (root == null) {
        //     return null;
        // }
        // Queue<Node> queue = new LinkedList<>();
        // queue.add(root);
        // while (!queue.isEmpty()) {
        //     int size = queue.size();
        //     for (int i = 0; i < size; i++) {
        //         Node temp = queue.poll();
        //         if (i < size - 1) {
        //             temp.next = queue.peek();
        //         }
        //         if (temp.left != null) {
        //             queue.add(temp.left);
        //         }
        //         if (temp.right != null) {
        //             queue.add(temp.right);
        //         }
        //     }
        // }
        // return root;
        if (root == null) {
            return null;
        }
        Node curr = root, prev = null;
        Node dummy = null;
        while (curr != null) {
            dummy = new Node(0);
            prev = dummy;
            while (curr != null) {
                if (curr.left != null) {
                    prev.next = curr.left;
                    prev =prev.next;
                }
                if (curr.right != null) {
                    prev.next = curr.right;
                    prev = prev.next;
                }
                curr = curr.next;
            }
            curr = dummy.next;
        }
        return root;
    }
}