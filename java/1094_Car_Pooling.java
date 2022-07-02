class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // priority queue
        // Arrays.sort(trips, (a,b)->a[1]-b[1]);
        // Queue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        // for (int[] t : trips) {
        //     while (!pq.isEmpty() && pq.peek()[2]<=t[1]) {
        //         capacity += pq.peek()[0];
        //         pq.poll();
        //     }
        //     capacity -= t[0];
        //     if (capacity<0) return false;
        //     pq.offer(t);
        // }
        // return true;
        // treemap
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] t : trips) {
            map.put(t[1], map.getOrDefault(t[1], 0)+t[0]);
            map.put(t[2], map.getOrDefault(t[2], 0)-t[0]);
        }
        for (int n : map.values()) {
            capacity -= n;
            if (capacity<0) return false;
        }
        return true;
    }
}