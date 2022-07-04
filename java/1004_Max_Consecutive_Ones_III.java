class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, res = Integer.MIN_VALUE;
        while (r<nums.length) {
            if (k>=0) {
                if (nums[r]==0) k--;
                r++;
            }
            while (k<0) {
                if (nums[l]==0) k++;
                l++;
            }
            res = Math.max(res, r-l);
        }
        return res;
    }
}