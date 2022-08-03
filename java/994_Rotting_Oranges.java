class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        int m = grid.length, n = grid[0].length;
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                if (grid[i][j]==2)
                    queue.offer(new int[]{i, j});
                else if (grid[i][j]==1)
                    count++;
        queue.offer(new int[]{-1, -1});
        int time = -1;
        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        while (!queue.isEmpty()) {
            int[] o = queue.poll();
            int r = o[0], c = o[1];
            if (r==-1) {
                time++;
                if (!queue.isEmpty())
                    queue.offer(new int[]{-1, -1});
            } else {
                for (int[] d : dir) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr>=0 && nr<m && nc>=0 && nc<n)
                        if (grid[nr][nc]==1) {
                            grid[nr][nc] = 2;
                            count--;
                            queue.offer(new int[]{nr, nc});
                        }
                }
            }
        }
        return count==0 ? time : -1;
    }
}