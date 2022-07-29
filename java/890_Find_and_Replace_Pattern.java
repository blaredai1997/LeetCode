class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word: words)
            if (helper(word, pattern))
                res.add(word);
        return res;
    }
    private boolean helper(String word, String pattern) {
        Map<Character, Character> map = new HashMap<>();
        boolean[] list = new boolean[26];
        for (int i=0; i<word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!map.containsKey(w)) {
                map.put(w, p);
                if (list[p-'a']) return false;
                list[p-'a'] = true;
            }
            if (map.get(w)!=p) return false;
        }
        return true;
    }
}