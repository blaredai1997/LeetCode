class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        // if (nums[l]>target) return 0;
        // if (nums[r]<target) return r+1;
        // while (l<r) {
        //     if (nums[l]<target)
        //         l++;
        //     else if (nums[r]>target)
        //         r--;
        // }
        // return l;
        while (l<=r) {
            int mid = (l+r)/2;
            if (nums[mid]==target)
                return mid;
            else if (nums[mid]>target)
                r = mid-1;
            else
                l = mid+1;
        }
        return l;
    }
}