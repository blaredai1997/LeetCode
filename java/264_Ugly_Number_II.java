class Solution {
    public int nthUglyNumber(int n) {
        // (1) 1×2, 2×2, 3×2, 4×2, 5×2, 6x2, 8x2,…
        // (2) 1×3, 2×3, 3×3, 4×3, 5×3, 6x3, 8x3,…
        // (3) 1×5, 2×5, 3×5, 4×5, 5×5, 6x5, 8x5,…
        int[] res = new int[n];
        res[0] = 1;
        int i2 = 1, i3 = 1, i5 = 1;
        int f2 = 2, f3 = 3, f5 = 5;
        for (int i=1; i<n; i++) {
            int min = Math.min(Math.min(f2, f3), f5);
            res[i] = min;
            if (min==f2) f2 = 2 * res[i2++];
            if (min==f3) f3 = 3 * res[i3++];
            if (min==f5) f5 = 5 * res[i5++];
        }
        return res[n-1];
    }
}