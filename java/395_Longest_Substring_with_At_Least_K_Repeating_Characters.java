class Solution {
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int[] counter = new int[26];
        int res = 0, maxChar = getMaxUniqueChar(str);
        for (int i = 1; i<=maxChar; i++) {
            Arrays.fill(counter, 0);
            int l = 0, r = 0, count = 0, countK = 0, idx = 0;
            while (r<s.length()) {
                if (count<=i) {
                    idx = s.charAt(r)-'a';
                    if (counter[idx]==0) count++;
                    counter[idx]++;
                    if (counter[idx]==k) countK++;
                    r++;
                }
                else {
                    idx = s.charAt(l)-'a';
                    if (counter[idx]==k) countK--;
                    counter[idx]--;
                    if (counter[idx]==0) count--;
                    l++;
                }
                if (count == i && count == countK)
                    res = Math.max(r-l, res);
            }
        }
        return res;
    }
    public int getMaxUniqueChar(char[] str) {
        Set<Character> set = new HashSet<>();
        for (char c : str) set.add(c);
        return set.size();
    }
}