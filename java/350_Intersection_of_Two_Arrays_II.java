class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m = nums1.length, n = nums2.length;
        List<Integer> res = new ArrayList<>();
        int l = 0, r = 0;
        while (l < m && r < n) {
            if (nums1[l] == nums2[r]) {
                res.add(nums1[l]);
                l++;
                r++;
            } else if (nums1[l] < nums2[r]) {
                l++;
            } else {
                r++;
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}