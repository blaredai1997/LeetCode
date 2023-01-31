class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length, k = n - 1;
        for (int i = 0; i < n; i++) {
            if (grid[i][i] == 0) return false;
            for (int j = 0; j < n; j++)
                if (i != j && j != k && grid[i][j] != 0)
                    return false;
            if (k >=0 && grid[i][k--] == 0) return false;
        }
        return true;
    }
}