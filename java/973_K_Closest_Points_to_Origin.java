class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        int[][] res = new int[k][2];
        for (int i=0; i<points.length; i++) {
            int[] p = {distance(points[i]), i};
            if (pq.size()<k) pq.offer(p);
            else if (p[0]<pq.peek()[0]) {
                pq.poll();
                pq.offer(p);
            }
        }
        for (int i=0; i<k; i++)
            res[i] = points[pq.poll()[1]];
        return res;
    }
    private int distance(int[] point) {
        return point[0]*point[0] + point[1]*point[1];
    }
}