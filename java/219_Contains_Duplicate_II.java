class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = 0, r= 0;
        Set<Integer> set = new HashSet<>();
        while (r<nums.length) {
            if (!set.add(nums[r++])) return true;
            else
                if (r>=k+1) set.remove(nums[r-k-1]); 
        }
        return false;
    }
}