class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> score[b] - score[a]); // lambda expression, usually (a,b) return a-b
        for (int i=0; i<score.length; i++)
            pq.add(i);
        String[] res = new String[score.length];
        int i = 1;
        while (!pq.isEmpty()) {
            int idx = pq.poll();
            if (i==1) res[idx] = "Gold Medal";
            else if (i==2) res[idx] = "Silver Medal";
            else if (i==3) res[idx] = "Bronze Medal";
            else res[idx] = String.valueOf(i);
            i++;
        }
        return res;
    }
}