class Solution {
    int[][] dirs = {{0,-1}, {0,1}, {-1,0}, {1,0}};
    public int getFood(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        int res = 0;
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                if (grid[i][j]=='*')
                    q.add(new int[]{i, j});
        while (!q.isEmpty()) {
            int len = q.size();
            while (len-->0) {
                int[] idx = q.poll();
                int row = idx[0], col = idx[1];
                if (grid[row][col]=='#') return res;
                for (int[] dir : dirs) {
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if (r>=0 && c>=0 && r<m && c<n && grid[r][c]!='X' && !seen[r][c]) {
                        seen[r][c] = true;
                        q.add(new int[]{r, c});
                    }
                }
            }
            res++;
        }
        return -1;
    }
}