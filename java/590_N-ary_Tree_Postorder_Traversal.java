/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        recursion(res, root);
        return res;    
    }
    public void recursion(List<Integer> res, Node curr) {
        if (curr==null) return;
        for (Node child : curr.children)
            recursion(res, child);
        res.add(curr.val);
    }
}