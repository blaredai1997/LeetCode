class Solution {
    public int missingNumber(int[] nums) {
        // Arrays.sort(nums);
        // int l = 0, r = nums.length;
        // while (l<r) {
        //     int mid = l + (r-l)/2;
        //     if (nums[mid]>mid) 
        //         r = mid;
        //     else 
        //         l = mid + 1;
        // }
        // return l;
        int res = nums.length;
        for(int i=0; i<nums.length; i++){
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }
}