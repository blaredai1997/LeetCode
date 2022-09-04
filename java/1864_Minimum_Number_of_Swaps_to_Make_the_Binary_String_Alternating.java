class Solution {
    public int minSwaps(String s) {
        int zeros = 0, ones = 0;
        for (char c : s.toCharArray())
            if (c=='0') zeros++;
            else ones++;
        if (Math.abs(zeros-ones)>1)
            return -1;
        if (zeros>ones)
            return helper(s, '0');
        else if (ones>zeros)
            return helper(s, '1');
        return Math.min(helper(s, '0'), helper(s, '1'));
    }
    private int helper(String s, char c) {
        int count = 0;
        for (char C : s.toCharArray()) {
            if (C!=c) count++;
            c ^= 1;
        }
        return count/2;
    }
}