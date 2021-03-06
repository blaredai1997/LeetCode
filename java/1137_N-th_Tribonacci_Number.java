class Solution {
    public int tribonacci(int n) {
        if (n==0) return 0;
        int t0 = 0, t1 = 1, t2 = 1;
        for (int i=2; i<n; i++) {
            int temp = t0+t1+t2;
            t0 = t1;
            t1 = t2;
            t2 = temp;
        }
        return t2;
    }
}