class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int minCost1 = cost[0], minCost2 = cost[1];
        for (int i=2; i<cost.length; i++) {
            int temp = cost[i] + Math.min(minCost1, minCost2);
            minCost1 = minCost2;
            minCost2 = temp;
        }
        return Math.min(minCost1, minCost2);
    }
}