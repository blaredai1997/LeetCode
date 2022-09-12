class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int res = 0, score = 0, l = 0, r = tokens.length-1;
        while (l<=r && (power>=tokens[l] || score>0)) {
            while (l<=r && power>=tokens[l]) {
                power -= tokens[l++];
                score++;
            }
            res = Math.max(res, score);
            if (l<=r && score>0) {
                power += tokens[r--];
                score--;
            }
        }
        return res;
    }
}