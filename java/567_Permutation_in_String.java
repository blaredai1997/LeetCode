class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n) {
            return false;
        }
        int[] table  = new int[26];
        for (int i = 0; i < m; i++) {
            table[s1.charAt(i) - 'a']++;
            table[s2.charAt(i) - 'a']--;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (table[i] != 0) {
                diff++;
            }
        }
        if (diff == 0) {
            return true;
        }
        for (int i = 0; i + m < n; i++) {
            if (table[s2.charAt(i) - 'a'] == -1) {
                diff--;
            } else if (table[s2.charAt(i) - 'a'] == 0) {
                diff++;
            }
            table[s2.charAt(i) - 'a']++;
            if (table[s2.charAt(i + m) - 'a'] == 1) {
                diff--;
            } else if (table[s2.charAt(i + m) - 'a'] == 0) {
                diff++;
            }
            table[s2.charAt(i + m) - 'a']--;
            if (diff == 0) {
                return true;
            }
        }
        return false;
    }
}