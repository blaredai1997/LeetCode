class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0, res = 0;
        while (r<s.length()) {
            if (!set.add(s.charAt(r))) {
                res = Math.max(res, r-l);
                while (s.charAt(l)!=s.charAt(r))
                    set.remove(s.charAt(l++));
                l++;
            }
            r++;
        }
        return Math.max(res, r-l);
    }
}