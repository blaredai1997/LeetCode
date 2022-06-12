class Solution {
    public boolean isHappy(int n) {
        // Set<Integer> set = new HashSet<>();
        // while (!set.contains(n)) {
        // hardcoding the cycle
        while (n!=4) {
            // set.add(n);
            n = sumOfSquares(n);
            if (n==1) return true;
        }
        return false;
    }
    public int sumOfSquares(int n) {
        int sum = 0;
        while (n>0) {
            int d = n % 10;
            n /= 10;
            sum += d * d;
        }
        return sum;
    }
}