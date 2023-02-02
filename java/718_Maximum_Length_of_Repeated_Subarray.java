class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        return nums1.length < nums2.length ? findMax(nums1, nums2) : findMax(nums2, nums1);
    }
    public int findMax(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int max = 0;
        for (int i = 1; i < m; i++) {
            max = Math.max(max, findMaxLength(nums1, nums2, 0, n - i, i));
        }
        for (int i = n - m; i >= 0; i--) {
            max = Math.max(max, findMaxLength(nums1, nums2, 0, i, m));
        }
        for (int i = 1; i < m; i++) {
            max = Math.max(max, findMaxLength(nums1, nums2, i, 0, m - i));
        }
        return max;
    }
    public int findMaxLength(int[] nums1, int[] nums2, int x, int y, int len) {
        int max = 0, count = 0;
        for (int i = 0; i < len; i++) {
            if (nums1[x + i] == nums2[y + i]) {
                count++;
            } else if (count > 0) {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(max, count);
    }
}