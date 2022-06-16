class Solution {
    public int arrangeCoins(int n) {
        long l = 0, r = n, k, level;
        while (l<=r) {
            k = l + (r-l)/2;
            level = (k+1)*k/2;
            if (level==n) return (int)k;
            else if (level<n) l = k+1;
            else r = k-1;
        }
        return (int)r;
    }
}