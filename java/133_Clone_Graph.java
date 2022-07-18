/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    // dfs
    // public Node cloneGraph(Node node) {
    //     Map<Integer, Node> map = new HashMap<>();
    //     return helper(map, node);
    // }
    // public Node helper(Map<Integer, Node> map, Node node) {
    //     if (node==null) return null;
    //     if (map.containsKey(node.val)) return map.get(node.val);
    //     Node copy = new Node(node.val);
    //     map.put(copy.val, copy);
    //     for (Node n : node.neighbors)
    //         copy.neighbors.add(helper(map, n));
    //     return copy;
    // }
    // bfs
    public Node cloneGraph(Node node) {
        if (node==null) return null;
        Map<Integer, Node> map = new HashMap<>();
        map.put(node.val, new Node(node.val));
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node N = queue.poll();
            for (Node n : N.neighbors) {
                if (!map.containsKey(n.val)) {
                    map.put(n.val, new Node(n.val));
                    queue.offer(n);
                }
                map.get(N.val).neighbors.add(map.get(n.val));
            }
        }
        return map.get(node.val);
    }
}