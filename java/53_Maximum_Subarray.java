class Solution {
    public int maxSubArray(int[] nums) {
        // int[] resList = new int[nums.length];
        // resList[0] = nums[0];
        // int res = resList[0];
        // for (int i=1; i<nums.length; i++) {
        //     resList[i] = Math.max(resList[i-1]+nums[i], nums[i]);
        //     res = Math.max(res, resList[i]);
        // }
        // return res;
        return recursion(nums, 0, nums.length-1);
    }
    public int recursion(int[] nums, int left, int right) {
        if (left==right)
            return nums[left];
        int mid = (left+right)/2;
        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
        for (int i=mid, sum=0; i>=left; i--)
            leftMax = Math.max(sum+=nums[i], leftMax);
        for (int i=mid+1, sum=0; i<=right; i++)
            rightMax = Math.max(sum+=nums[i], rightMax);
        return Math.max(Math.max(recursion(nums, left, mid), recursion(nums, mid+1, right)), leftMax+rightMax);
    }
}