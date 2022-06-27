class Solution {
    public int[] constructRectangle(int area) {
        // Math.sqrt for area < 4 would be 1
        int W = (int)Math.sqrt(area);
        while (area%W!=0) W--;
        return new int[]{area/W, W};
    }
}