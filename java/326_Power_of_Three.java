class Solution {
    public boolean isPowerOfThree(int n) {
        // if (n<1) return false;
        // while (n%3==0) n /= 3;
        // return n==1;
        // find the maximum power of three value of n
        return n > 0 && 1162261467 % n == 0;
    }
}