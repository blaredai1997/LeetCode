class Solution {
    public int search(int[] nums, int target) {
        // search for the min index
        // int l = 0;
        // int r = nums.length-1;
        // while (l<r) {
        //     int mid = (l+r)/2;
        //     if (nums[mid]<nums[r])
        //         r = mid;
        //     else
        //         l = mid+1;
        // }
        // int min = l;
        // perform binary search with permutation of the min index
        // l = 0;
        // r = nums.length-1;
        // while (l<=r) {
        //     int mid = (l+r)/2, mid_rotate = (mid+min)%nums.length;
        //     if (nums[mid_rotate]==target)
        //         return mid_rotate;
        //     else if (nums[mid_rotate]<target)
        //         l = mid+1;
        //     else
        //         r = mid-1;
        // }
        int l = 0;
        int r = nums.length;
        while (l<r) {
            int mid = (l+r)/2;
            // check if nums[mid] and target are on the same side of nums[0]
            // if yes, perform binary search
            // if no, replace values greater than target to -INF and values lower than target to INF
            double num = 0;
            if ((nums[mid]<nums[0])==(target<nums[0]))
                num = nums[mid];
            else {
                if (target<nums[0])
                    num = Double.NEGATIVE_INFINITY;
                else
                    num = Double.POSITIVE_INFINITY;
            }
            if (num<target)
                l = mid+1;
            else if (num>target)
                r = mid;
            else
                return mid;
        }
        return -1;
    }
}