class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l<=r) {
            int mid = (l+r)/2;
            if (nums[mid]==target) {
                l = r = mid;
                while (l>=0 && nums[l]==target) l--;
                while (r<=nums.length-1 && nums[r]==target) r++;
                return new int[] {l+1, r-1};
            }
            else if (nums[mid]>target)
                r = mid-1;
            else
                l = mid+1;
        }
        return new int[] {-1, -1};
    }
}