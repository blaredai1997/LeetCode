class Solution {
    public int removeElement(int[] nums, int val) {
        // int k = 0;
        // for (int i=0; i<nums.length; i++)
        //     if (nums[i]!=val)
        //         nums[k++] = nums[i];
        // return k;
        int l = 0, r = nums.length;
        while (l<r) {
            if (nums[l]==val) {
                nums[l] = nums[r-1];
                r--;
            }
            else l++;
        }
        return r;
    }
}