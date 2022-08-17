class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] table = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for (String word : words) {
            String s = "";
            for (char c : word.toCharArray())
                s += table[c-'a'];
            set.add(s);
        }
        return set.size();
    }
}