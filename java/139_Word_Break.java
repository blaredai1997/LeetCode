class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Queue<Integer> q = new LinkedList<>();
        // boolean[] visited = new boolean[s.length()];
        // q.offer(0);
        // while (!q.isEmpty()) {
        //     int idx = q.poll();
        //     if (visited[idx]) continue;
        //     for (int i=idx+1; i<=s.length(); i++)
        //         if (wordDict.contains(s.substring(idx, i))) {
        //             q.offer(i);
        //             if (i==s.length()) return true;
        //         }
        //     visited[idx] = true;
        // }
        // return false;
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i=1; i<=s.length(); i++)
        for (int j=0; j<i; j++)
            if (dp[j] && wordDict.contains(s.substring(j, i))) {
                dp[i] = true;
                break;
            }
        return dp[s.length()];
    }
}