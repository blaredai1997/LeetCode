class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1]-a[1]);
        int max = 0;
        for (int[] t : boxTypes) {
            if (truckSize-t[0]>=0) {
                max += t[0] * t[1];
                truckSize -= t[0];
            } else {
                max += truckSize * t[1];
                break;
            }
        }
        return max;
    }
}