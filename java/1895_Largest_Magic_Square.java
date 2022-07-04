class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] rows = new int[m+1][n+1];
        int[][] cols = new int[m+1][n+1];
        int[][] dias1 = new int[m+1][n+1];
        int[][] dias2 = new int[m+1][n+1];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                rows[i+1][j+1] += grid[i][j] + rows[i+1][j];
                cols[i+1][j+1] += grid[i][j] + cols[i][j+1];
                dias1[i+1][j+1] += grid[i][j] + dias1[i][j];
                dias2[m-i-1][n-j] += grid[m-i-1][n-j-1] + dias2[m-i][n-j-1];
            }
        }
        int k = Math.min(m, n);
        while (k>1) {
            for (int i=k-1; i<m; i++) {
                for (int j=k-1; j<n; j++) {
                    int dv1 = dias1[i+1][j+1]-dias1[i-k+1][j-k+1];
                    int dv2 = dias2[i-k+1][j+1]-dias2[i+1][j-k+1];
                    if (dv1!=dv2) continue;
                    boolean isRow = true;
                    for (int s=i-k+1; s<=i; s++) {
                        if (rows[s+1][j+1]-rows[s+1][j-k+1]!=dv1) {
                            isRow = false;
                            break;
                        }
                    }
                    if (!isRow) continue;
                    boolean isCol = true;
                    for (int s=j-k+1; s<=j; s++) {
                        if (cols[i+1][s+1]-cols[i-k+1][s+1]!=dv1) {
                            isCol = false;
                            break;
                        }
                    }
                    if (!isCol) continue;
                    if (isRow && isCol) return k;
                }
            }
            k--;
        }
        return 1;
    }
}