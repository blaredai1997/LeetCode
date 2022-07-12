class Solution {
    public int islandPerimeter(int[][] grid) {
        int lands = 0, besides = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j]==1) {
                    lands++;
                    if (i+1<grid.length && grid[i+1][j]==1) besides++;
                    if (j+1<grid[0].length && grid[i][j+1]==1) besides++;
                }
            }
        }
        return 4*lands-2*besides;
    }
}