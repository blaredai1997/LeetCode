class Solution {
    // long res = 0;
    // public long numberOfWays(String s) {
    //     StringBuilder sb = new StringBuilder();
    //     int n = s.length();
    //     helper(s, sb, 0);
    //     return res;
    // }
    // private void helper(String s, StringBuilder sb, int idx) {
    //     if (sb.length()==3) {
    //         if (sb.toString().equals("010") ||
    //             sb.toString().equals("101"))
    //             res++;
    //         return;
    //     }
    //     for (int i=idx; i<s.length(); i++) {
    //         sb.append(s.charAt(i));
    //         helper(s, sb, i+1);
    //         sb.deleteCharAt(sb.length()-1);
    //     }
    // }
    public long numberOfWays(String s) {
        int zeros = 0, ones = 0;
        long zos = 0, ozs = 0, res = 0;
        for (char c : s.toCharArray()) {
            if (c=='0') {
                zeros++;
                ozs += ones;
                res += zos;
            } else {
                ones++;
                zos += zeros;
                res += ozs;
            }
        }
        return res;
    }
}