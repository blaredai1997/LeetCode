class NumArray {
    int[] nums;
    public NumArray(int[] nums) {
        for (int i=1; i<nums.length; i++)
            nums[i] += nums[i-1];
        this.nums = nums;
    }
    
    public int sumRange(int left, int right) {
        // int sum = 0;
        // for (int i=left; i<=right; i++)
        //     sum += nums[i];
        // return sum;
        return nums[right]-(left==0 ? 0 : nums[left-1]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */