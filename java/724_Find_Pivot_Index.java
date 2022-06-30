class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int sum = 0, l = 0;
        for (int i=0; i<n; i++) sum += nums[i];
        for (int i=0; i<n; i++) {
            if (l==sum-l-nums[i]) return i;
            l += nums[i];
        }
        return -1;
    }
}