class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length==0) return m*n;
        int r = Integer.MAX_VALUE, c = Integer.MAX_VALUE;
        for (int i=0; i<ops.length; i++) {
            r = Math.min(ops[i][0], r);
            c = Math.min(ops[i][1], c);
        }
        return r*c;
    }
}