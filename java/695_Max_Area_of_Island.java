class Solution {
    int area;
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i=0; i<grid.length; i++)
            for (int j=0; j<grid[0].length; j++)
                if (grid[i][j]==1) {
                    area = 0;
                    sink(grid, i, j);
                    max = Math.max(max, area);
                }
        return max;
    }
    public void sink(int[][] grid, int i, int j) {
        if (i<0 || j<0 || i==grid.length || j==grid[0].length) return;
        if (grid[i][j]==1) {
            area++;
            grid[i][j] = 0;
            sink(grid, i-1, j);
            sink(grid, i+1, j);
            sink(grid, i, j-1);
            sink(grid, i, j+1);
        }
    }
}