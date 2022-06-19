class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n<=0) return false;
        // while (n/2>1) {
        //     if (n%2!=0) return false;
        //     else n /= 2;
        // }
        // if (n==3) return false;
        // return true;
        return (n&(n-1))==0;
    }
}