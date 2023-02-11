class Solution {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        if (amount[2] >= amount[1] + amount[0]) {
            return amount[2];
        }
        return (amount[2] + amount[1] + amount[0] + 1) / 2;
    }
}