class Solution {
    public boolean isPerfectSquare(int num) {
        int l = 1, r = num;
        while (l<=r) {
            int mid = l + (r-l)/2;
            if (num%mid==0 && num/mid==mid) return true;
            if (num/mid>mid) l = mid+1;
            else r = mid-1;
        }
        return false;
    }
}