class Solution {
    // public int[][] merge(int[][] intervals) {
    //     Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
    //     ArrayList<int[]> res = new ArrayList<>();
    //     int l = intervals[0][0], r = intervals[0][1];
    //     for (int i=1; i<intervals.length; i++) {
    //         if (r>=intervals[i][1]) continue;
    //         else if (r>=intervals[i][0])
    //             r = intervals[i][1];
    //         else {
    //             res.add(new int[]{l, r});
    //             l = intervals[i][0];
    //             r = intervals[i][1];
    //         }
    //     }
    //     res.add(new int[]{l, r});
    //     return res.toArray(new int[res.size()][]);
    // }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        ArrayList<int[]> res = new ArrayList<>();
        for (int[] i : intervals)
            if (res.isEmpty() || res.get(res.size()-1)[1]<i[0])
                res.add(i);
            else res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1], i[1]);
        return res.toArray(new int[res.size()][]);
    }
}