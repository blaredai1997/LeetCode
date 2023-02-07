class Solution {
    public int totalFruit(int[] fruits) {
        int res = 0, n = fruits.length;
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        while (r < n) {
            int f1 = fruits[r];
            map.put(f1, map.getOrDefault(f1, 0) + 1);
            r++;
            if (map.size() > 2){
                while (map.size() > 2) {
                    int f2 = fruits[l];
                    if (map.get(f2) - 1 == 0) {
                        map.remove(f2);
                    } else {
                        map.put(f2, map.get(f2) - 1);
                    }
                    l++;
                }
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}