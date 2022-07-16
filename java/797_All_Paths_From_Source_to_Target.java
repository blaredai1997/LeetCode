class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        helper(res, temp, graph, 0);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> temp, int[][] graph, int idx) {
        if (idx==graph.length-1) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i=0; i<graph[idx].length; i++) {
            temp.add(graph[idx][i]);
            helper(res, temp, graph, graph[idx][i]);
            temp.remove(temp.size()-1);
        }
    }
}