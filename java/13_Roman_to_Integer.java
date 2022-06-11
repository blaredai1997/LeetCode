class Solution {
    public int romanToInt(String s) {
        int[] a = new int[26];
        a['I'-'A'] = 1;
        a['V'-'A'] = 5;
        a['X'-'A'] = 10;
        a['L'-'A'] = 50;
        a['C'-'A'] = 100;
        a['D'-'A'] = 500;
        a['M'-'A'] = 1000;
        char prev = 'A';
        int res = 0;
        for (char c : s.toCharArray()) {
            if (a[c-'A']>a[prev-'A'])
                res -= 2*a[prev-'A'];
            res += a[c-'A'];
            prev = c;
        }
        return res;
    }
}