class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, len = 1;
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 0; i < n; i++) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, idx = 0;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (d[mid] < nums[i]) {
                        idx = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[idx + 1] = nums[i];
            }
        }
        return len;
    }
}