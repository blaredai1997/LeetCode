class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        // Queue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
        // for (int[] i : intervals) {
        //     if (!pq.isEmpty() && i[0]>=pq.peek()) pq.poll();
        //     pq.offer(i[1]);
        // }
        // return pq.size();
        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];
        for (int i=0; i<intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start, (a,b)->a-b);
        Arrays.sort(end, (a,b)->a-b);
        int res = 0;
        int s = 0, e = 0;
        while (s<intervals.length) {
            if (start[s]>=end[e]) {
                res--;
                e++;
            }
            res++;
            s++;
        }
        return res;
    }
}