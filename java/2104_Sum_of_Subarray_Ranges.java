class Solution {
    public long subArrayRanges(int[] nums) {
        // f(i) = (left[i] + 1) * (right[i] + 1)
        // For [3,1,2,4] as example:
        // left + 1 = [1,2,1,1]
        // right + 1 = [1,3,2,1]
        // f = [1,6,2,1]
        // res = 3 * 1 + 1 * 6 + 2 * 2 + 4 * 1 = 17
        int n = nums.length, j, k;
        long res = 0;
        Stack<Integer> s = new Stack<>();
        for (int i=0; i<=n; i++) {
            while (!s.isEmpty() && nums[s.peek()]>(i==n ? Integer.MIN_VALUE : nums[i])) {
                j = s.pop();
                k = s.isEmpty() ? -1 : s.peek();
                res -= (long)nums[j]*(i-j)*(j-k);
            }
            s.push(i);
        }
        s.clear();
        for (int i=0; i<=n; i++) {
            while (!s.isEmpty() && nums[s.peek()]<(i==n ? Integer.MAX_VALUE : nums[i])) {
                j = s.pop();
                k = s.isEmpty() ? -1 : s.peek();
                res += (long)nums[j]*(i-j)*(j-k);
            }
            s.push(i);
        }
        return res;
    }
}