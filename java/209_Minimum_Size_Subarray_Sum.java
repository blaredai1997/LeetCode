class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // sliding window in O(n)
        // int l = 0, r = 0, sum = 0, min = Integer.MAX_VALUE;
        // while (r<nums.length) {
        //     sum += nums[r++];
        //     while (sum>=target) {
        //         min = Math.min(min, r-l);
        //         sum -= nums[l++];
        //     }
        // }
        // return min==Integer.MAX_VALUE ? 0 : min;
        // binary search in O(nlogn)
        int l = 1, r = nums.length, min = 0;
        while (l<=r) {
            int mid = l + (r-l)/2;
            if (isExist(target, nums, mid)) {
                r = mid - 1;
                min = mid;
            }
            else l = mid + 1;
        }
        return min;
    }
    public boolean isExist(int target, int[] nums, int size) {
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            if (i>=size) sum -= nums[i-size];
            sum += nums[i];
            if (sum>=target) return true;
        }
        return false;
    }
}