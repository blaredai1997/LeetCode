class Solution {
    private int[][] heights;
    private int m, n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] paci = new boolean[m][n];
        boolean[][] atla = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i, 0, paci);
        }
        for (int i = 1; i < n; i++) {
            dfs(0, i, paci);
        }
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, atla);
        }
        for (int i = 0; i < n - 1; i++) {
            dfs(m - 1, i, atla);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (paci[i][j] && atla[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
            }
        }
        return res;
    }
    public void dfs(int i, int j, boolean[][] check) {
        if (check[i][j]) {
            return;
        }
        check[i][j] = true;
        if (i - 1 >= 0 && heights[i - 1][j] >= heights[i][j]) {
            dfs(i - 1, j, check);
        }
        if (i + 1 < m && heights[i + 1][j] >= heights[i][j]) {
            dfs(i + 1, j, check);
        }
        if (j - 1 >= 0 && heights[i][j - 1] >= heights[i][j]) {
            dfs(i, j - 1, check);
        }
        if (j + 1 < n && heights[i][j + 1] >= heights[i][j]) {
            dfs(i, j + 1, check);
        }
    }
}