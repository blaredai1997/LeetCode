class Solution {
    public int getMaxLen(int[] nums) {
        int res = 0;
        int pos = 0, neg = 0;
        for (int n : nums) {
            if (n==0) {
                pos = 0;
                neg = 0;
            } else if (n>0) {
                pos++;
                neg = neg==0 ? 0 : neg+1;
            } else {
                int temp = pos;
                pos = neg==0 ? 0 : neg+1;
                neg = temp+1;
            }
            res = Math.max(res, pos);
        }
        return res;
    }
}