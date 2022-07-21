class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n>max) max = n;
            if (n<min) min = n;
        }
        if (max-min<=2*k) return 0;
        return max-min-2*k;
    }
}