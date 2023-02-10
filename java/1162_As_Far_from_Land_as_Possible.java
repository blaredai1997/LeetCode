class Solution {
    private int[][] grid;
    private int m, n;
    public int maxDistance(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        int[][] visited = new int[m][n];
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = grid[i][j];
                if (grid[i][j] == 1) {
                    queue.add(new Pair(i, j));
                }
            }
        }
        int res = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Pair<Integer, Integer> p = queue.poll();
                int i = p.getKey(), j = p.getValue();
                if (i - 1 >= 0 && visited[i - 1][j] == 0) {
                    visited[i - 1][j] = 1;
                    queue.add(new Pair(i - 1, j));
                }
                if (i + 1 < m && visited[i + 1][j] == 0) {
                    visited[i + 1][j] = 1;
                    queue.add(new Pair(i + 1, j));
                }
                if (j - 1 >= 0 && visited[i][j - 1] == 0) {
                    visited[i][j - 1] = 1;
                    queue.add(new Pair(i, j - 1));
                }
                if (j + 1 < n && visited[i][j + 1] == 0) {
                    visited[i][j + 1] = 1;
                    queue.add(new Pair(i, j + 1));
                }
            }
            res++;
        }
        return res == 0 ? -1 : res;
    }
}