class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int n = arr.length, j, k;
        long res = 0;
        for (int i=0; i<=n; i++) {
            while (!s.isEmpty() && arr[s.peek()]>(i==n ? Integer.MIN_VALUE : arr[i])) {
                j = s.pop();
                k = s.isEmpty() ? -1 : s.peek();
                res += ((long)arr[j]*(i-j)*(j-k)) % 1000000007;
                res %= 1000000007;
            }
            s.push(i);
        }
        return (int)res;
    }
}