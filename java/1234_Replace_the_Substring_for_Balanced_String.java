class Solution {
    public int balancedString(String s) {
        int n = s.length();
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'A']++;
        }
        int l = 0, r = 0, res = n;
        while (l < n) {
            while (r < n && !check(cnt, n / 4)) {
                cnt[s.charAt(r++) - 'A']--;
            }
            if (!check(cnt, n / 4)) {
                break; 
            }
            res = Math.min(res, r - l);
            cnt[s.charAt(l++) - 'A']++;
        }
        return res;
    }
    public boolean check(int[] cnt, int limit) {
        if (cnt['Q' - 'A'] > limit || cnt['W' - 'A'] > limit || 
            cnt['E' - 'A'] > limit || cnt['R' - 'A'] > limit) {
            return false;
        }
        return true;
    }
}