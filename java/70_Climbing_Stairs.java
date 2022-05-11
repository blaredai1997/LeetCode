class Solution {
    public int climbStairs(int n) {
        if (n==1) return 1;
        int n1 = 1, n2 = 1, res = 0;
        for (int i=2; i<=n; i++) {
            res = n1+n2;
            n1 = n2;
            n2 = res;
        }
        return res;
    }
}