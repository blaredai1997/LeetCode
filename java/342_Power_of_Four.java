class Solution {
    public boolean isPowerOfFour(int n) {
        // 4^n - 1 = (2^n+1)(2^n-1)
        // any consecutive 3 numbers will have one %3==0
        return n>0 && (n&(n-1))==0 && (n-1)%3==0;
    }
}