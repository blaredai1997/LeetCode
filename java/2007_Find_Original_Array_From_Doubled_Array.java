class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n%2!=0) return new int[0];
        int[] res = new int[n/2];
        Map<Integer, Integer> map = new TreeMap<>();
        for (int c : changed)
            map.put(c, map.getOrDefault(c, 0)+1);
        int count  = 0;
        for (int c : map.keySet()) {
            if (map.get(c)>map.getOrDefault(2*c, 0))
                return new int[0];
            for (int i=0; i<map.get(c); i++) {
                res[count++] = c;
                map.put(2*c, map.get(2*c)-1);
            }
        }
        return res;
    }
}