class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a,b) -> ages[a] == ages[b] ? scores[a] - scores[b] : ages[a] - ages[b]);
        int ans = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = scores[idx[i]];
            for (int j = 0; j < i; j++) {
                if (scores[idx[i]] >= scores[idx[j]]) {
                    dp[i] = Math.max(dp[i], dp[j] + scores[idx[i]]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}