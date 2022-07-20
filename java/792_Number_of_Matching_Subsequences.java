class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int res = 0;
        Map<Character, Queue<String>> map = new HashMap<>();
        for(char c='a'; c<='z'; c++)
            map.putIfAbsent(c, new LinkedList<>());
        for (String w : words)
            map.get(w.charAt(0)).add(w);
        for (char c : s.toCharArray()) {
            Queue<String> q = map.get(c);
            int len = q.size();
            for (int i=0; i<len; i++) {
                String str = q.poll();
                if (str.length()==1) res++;
                else map.get(str.charAt(1)).add(str.substring(1));
            }
        }
        return res;            
    }
}