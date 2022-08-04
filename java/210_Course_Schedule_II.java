class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int idx = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] degrees = new int[numCourses];
        for (int[] p : prerequisites) {
            List<Integer> nodes = map.getOrDefault(p[1], new ArrayList<>());
            nodes.add(p[0]);
            map.put(p[1], nodes);
            degrees[p[0]] += 1;
        }
        Queue<Integer> courses = new LinkedList<>();
        for (int n=0; n<numCourses; n++)
            if (degrees[n]==0)
                courses.add(n);
        while (!courses.isEmpty()) {
            int course = courses.poll();
            res[idx++] = course;
            if (map.containsKey(course))
                for (int next : map.get(course)) {
                    degrees[next] -= 1;
                    if (degrees[next]==0)
                        courses.add(next);
                }
        }
        if (idx!=numCourses) return new int[]{};
        return res;
    }
}