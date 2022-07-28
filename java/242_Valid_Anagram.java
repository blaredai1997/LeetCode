class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        Arrays.fill(count, 0);
        for (char c : s.toCharArray()) count[c-'a']++;
        for (char c : t.toCharArray()) count[c-'a']--;
        for (int i=0; i<count.length; i++) 
            if (count[i]!=0) return false;
        return true;
    }
}