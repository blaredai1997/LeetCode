class Node {
    public int degrees = 0;
    public List<Integer> Nodes = new LinkedList<>();
}
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length==0) return true;
        Map<Integer, Node> map = new HashMap<>();
        for (int[] p : prerequisites) {
            Node prev = getNode(map, p[1]);
            Node next = getNode(map, p[0]);
            prev.Nodes.add(p[0]);
            next.degrees += 1;
        }
        int depends = prerequisites.length;
        Queue<Integer> courses = new LinkedList<>();
        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            Node node = entry.getValue();
            if (node.degrees==0)
                courses.add(entry.getKey());
        }
        int remove = 0;
        while (courses.size()>0) {
            int course = courses.poll();
            for (int next : map.get(course).Nodes) {
                Node nNext = map.get(next);
                nNext.degrees -= 1;
                remove += 1;
                if (nNext.degrees==0)
                    courses.add(next);
            }
        }
        if (remove!=depends) return false;
        return true;
    }
    private Node getNode(Map<Integer, Node> map, int p) {
        Node node = null;
        if (map.containsKey(p))
            node = map.get(p);
        else {
            node = new Node();
            map.put(p, node);
        }
        return node;
    }
}