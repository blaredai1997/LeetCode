class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int m = a.length()-1, n = b.length()-1, passing = 0;
        while (m>=0 || n>=0) {
            int sum = passing;
            if (m>=0) sum += a.charAt(m--)-'0';
            if (n>=0) sum += b.charAt(n--)-'0';
            res.append(sum%2);
            passing = sum/2;
        }
        if (passing==1) res.append(1);
        return res.reverse().toString();
    }
}