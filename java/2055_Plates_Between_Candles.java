class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        // TreeMap<Integer, Integer> map = new TreeMap<>();
        // int idx = 0;
        // for (int i=0; i<s.length(); i++)
        //     if (s.charAt(i)=='|') map.put(i, idx++);
        // int[] res = new int[queries.length];
        // int count = 0;
        // for (int[] q : queries) {
        //     Integer c1 = map.ceilingKey(q[0]);
        //     Integer c2 = map.floorKey(q[1]);
        //     if (c1==null || c2==null || c1>c2) {
        //         count++;
        //         continue;
        //     }
        //     int nCandles = map.get(c2) - map.get(c1);
        //     res[count++] = c2 - c1 - nCandles;
        // }
        // return res;
        int n = s.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int[] candles = new int[n];
        int idx = -1, count = 0;
        for (int i=0; i<n; i++) {
            if (s.charAt(i)=='|') {
                idx = i;
                count++;
            }
            left[i] = idx;
            candles[i] = count;
        }
        idx = -1;
        for (int i=n-1; i>=0; i--) {
            if (s.charAt(i)=='|')
                idx = i;
            right[i] = idx;
        }
        int[] res = new int[queries.length];
        idx = 0;
        for (int[] q : queries) {
            int c1 = right[q[0]];
            int c2 = left[q[1]];
            if (c1==-1 || c2==-1 || c2-c1<=1)
                res[idx++] = 0;
            else
                res[idx++] = c2 - c1 - (candles[c2] - candles[c1]);
        }
        return res;
    }
}