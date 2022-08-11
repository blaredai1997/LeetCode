class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] ones = new int[n+1];
        for (int i=0; i<n; i++)
            if (s.charAt(i)=='1')
                ones[i+1] = ones[i] + 1;
            else ones[i+1] = ones[i];
        int res = Integer.MAX_VALUE;
        for (int i=0; i<n+1; i++)
            res = Math.min(res, ones[i]+(n-i)-(ones[n]-ones[i]));
        return res;
    }
}