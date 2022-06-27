class Solution {
    public int divisorSubstrings(int num, int k) {
        String N = String.valueOf(num);
        int i = 0, res = 0;
        while(i<=N.length()-k) {
            String sub = N.substring(i, i+k);
            int s = Integer.parseInt(sub);
            if (s!=0 && num%s==0) res++;
            i++;
        }
        return res;
    }
}