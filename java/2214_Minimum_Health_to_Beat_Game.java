class Solution {
    public long minimumHealth(int[] damage, int armor) {
        int max = Integer.MIN_VALUE;
        long res = 1;
        for (int i=0; i<damage.length; i++) {
            res += damage[i];
            max = Math.max(max, damage[i]);
        }
        res -= Math.min(max, armor);
        return res;
    }
}