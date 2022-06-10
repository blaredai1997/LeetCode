class Solution {
    public boolean isPalindrome(int x) {
        // char[] array = String.valueOf(x).toCharArray();
        // int l = 0, r = array.length-1;
        // while(l<r) {
        //     if (array[l]==array[r]) {
        //         l++;
        //         r--;
        //     }
        //     else
        //         return false;
        // }
        // return true;
        if (x<0 || (x%10==0 && x!=0)) return false;
        int revert = 0;
        while (x>revert) {
            revert = revert*10 + x%10;
            x /= 10;
        }
        return x==revert || x==revert/10;
    }
}