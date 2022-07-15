class CombinationIterator {
    PriorityQueue<String> pq;
    public CombinationIterator(String characters, int combinationLength) {
        pq = new PriorityQueue<>();
        helper(characters.toCharArray(), combinationLength, 0, new StringBuilder());
    }
    
    public void helper(char[] c, int len, int idx, StringBuilder sb) {
        if (len==0) {
            pq.offer(sb.toString());
            return;
        }
        for (int i=idx; i<=c.length-len; i++) {
            sb.append(c[i]);
            helper(c, len-1, i+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    public String next() {
        return pq.poll();
    }
    
    public boolean hasNext() {
        return !pq.isEmpty();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */