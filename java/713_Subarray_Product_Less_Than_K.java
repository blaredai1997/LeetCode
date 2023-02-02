class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        int temp = 1, l = 0;
        for (int r = 0; r < n; r++) {
            temp *= nums[r];
            while (l <= r && temp >= k) {
                temp /= nums[l];
                l++;
            }
            res += r - l + 1;
        }
        return res;
    }
}