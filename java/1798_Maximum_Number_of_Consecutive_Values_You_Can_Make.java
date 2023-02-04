class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int res = 1;
        for (int i : coins) {
            if (i > res) {
                break;
            }
            res += i;
        }
        return res;
    }
}