class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //////////////////////////////////////////////////////
        // two pointers
        // Set<Integer> set = new HashSet<>();
        // for (int i=0; i<nums2.length; i++) {
        //     int l = 0, r = nums1.length-1;
        //     while (l<=r) {
        //         if (nums1[l]==nums2[i] || nums1[r]==nums2[i])
        //             set.add(nums2[i]);
        //         l++;
        //         r--;
        //     }
        // }
        // List<Integer> list = new ArrayList<Integer>(set);
        /////////////////////////////////////////////////////
        // binary search
        // List<Integer> list = new ArrayList<>();
        // Arrays.sort(nums1);
        // Arrays.sort(nums2);
        // for (int i=0; i<nums2.length; i++) {
        //     if (i!=0 && nums2[i]==nums2[i-1]) continue;
        //     int l = 0, r = nums1.length-1;
        //     while(l<=r) {
        //         int mid = l + (r-l)/2;
        //         if (nums1[mid]==nums2[i]) {
        //             list.add(nums2[i]);
        //             break;
        //         }
        //         else if (nums1[mid]>nums2[i]) r = mid - 1;
        //         else l = mid + 1;
        //     }
        // }
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        for (int i=0; i<nums1.length; i++)
            set1.add(nums1[i]);
        for (int i=0; i<nums2.length; i++)
            if (set1.contains(nums2[i]))
                set.add(nums2[i]);
        List<Integer> list = new ArrayList<Integer>(set);
        int[] res = new int[list.size()];
        for (int i=0; i<res.length; i++)
            res[i] = list.get(i);
        return res;
    }
}