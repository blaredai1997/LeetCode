class Solution {
    int count = 0;
    public int countArrangement(int n) {
        boolean[] b = new boolean[n+1];
        recursion(n, 1, b);
        return count;
    }
    public void recursion(int n, int idx, boolean[] b) {
        if (idx>n) count++;
        for (int i=1; i<=n; i++)
            if (!b[i] && (idx%i==0 || i%idx==0)) {
                b[i] = true;
                recursion(n, idx+1, b);
                b[i] = false;
            }
    }
}