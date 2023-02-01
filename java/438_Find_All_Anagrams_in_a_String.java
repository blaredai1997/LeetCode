class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length(), n = p.length();
        if (m < n) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int[] table = new int[26];
        for (int i = 0; i < n; i++) {
            table[p.charAt(i) - 'a']++;
            table[s.charAt(i) - 'a']--;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (table[i] != 0) {
                diff++;
            }
        }
        if (diff == 0) {
            res.add(0);
        }
        for (int i = 0; i + n < m; i++) {
            if (table[s.charAt(i) - 'a'] == -1) {
                diff--;
            } else if (table[s.charAt(i) - 'a'] == 0) {
                diff++;
            }
            table[s.charAt(i) - 'a']++;
            if (table[s.charAt(i + n) - 'a'] == 1) {
                diff--;
            } else if (table[s.charAt(i + n) - 'a'] == 0) {
                diff++;
            }
            table[s.charAt(i + n) - 'a']--;
            if (diff == 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}