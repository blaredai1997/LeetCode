class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a-difference, 0)+1);
            res = Math.max(res, map.get(a));
        }
        return res;
    }
}