class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        while (numBottles/numExchange>0) {
            res += numBottles/numExchange;
            numBottles = numBottles/numExchange + numBottles%numExchange;
        }
        return res;
    }
}