class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        char[] charArray = s.toCharArray();
        int[] table = new int[26];
        int res = 0;
        int max = 0;
        int l = 0, r = 0;
        while (r < n) {
            table[charArray[r] - 'A']++;
            max = Math.max(max, table[charArray[r] - 'A']);
            r++;
            if (r - l > max + k) {
                table[charArray[l] - 'A']--;
                l++;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}