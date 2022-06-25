class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int l = 0, r = 0, sum = 0, max = Integer.MIN_VALUE;
        while (r<nums.length) {
            sum += nums[r++];
            if (r>=k) {
                max = Math.max(sum, max);
                sum -= nums[r-k];
            }
        }
        return (double)max/k;
    }
}