class Solution {
    int res = 0;
    public int subsetXORSum(int[] nums) {
        helper(nums, 0, 0);
        return res;
    }
    public void helper(int[] nums, int n, int total) {
        if (n==nums.length) return;
        for (int i=n; i<nums.length; i++) {
            total ^= nums[i];
            res += total;
            helper(nums, i+1, total);
            total ^= nums[i];
        }
    }
}