class Solution {
    public int firstUniqChar(String s) {
        // Map<Character, Integer> map = new HashMap<>();
        // for (char c : s.toCharArray())
        //     map.put(c, map.getOrDefault(c, 0)+1);
        // for (int i=0; i<s.length(); i++)
        //     if (map.get(s.charAt(i))==1)
        //         return i;
        // return -1;
        int res = Integer.MAX_VALUE;
        for (char c='a'; c<='z'; c++) {
            int i = s.indexOf(c);
            int j = s.lastIndexOf(c);
            if (i!=-1 && i==j)
                res = Math.min(res, i);
        }
        return res==Integer.MAX_VALUE ? -1 : res;
    }
}