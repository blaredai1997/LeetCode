class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        int count = words.length;
        for (char c : allowed.toCharArray())
            set.add(c);
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!set.contains(c)) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}