class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // sliding window
        // List<String> res = new ArrayList<>();
        // Map<String, Integer> map = new HashMap<>();
        // int l = 0, r = 0;
        // String sub = "";
        // while (r<s.length()) {
        //     sub += s.charAt(r++);
        //     if (r>=10) {
        //         if (map.containsKey(sub)) {
        //             map.put(sub, map.get(sub)+1);
        //             if (map.get(sub)==2) res.add(sub);
        //         }
        //         else map.put(sub, 1);
        //         sub = sub.substring(1);
        //     }
        // }
        // return res;
        Set<String> res = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int i=0; i+9<s.length(); i++) {
            String sub = s.substring(i,i+10);
            if (!set.add(sub)) res.add(sub);
        }
        return new ArrayList(res);
    }
}