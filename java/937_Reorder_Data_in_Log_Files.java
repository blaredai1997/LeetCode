class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Queue<String> pq = new PriorityQueue<>((a,b)-> 
            { 
                int a1 = a.indexOf(" "), b1 = b.indexOf(" ");
                String logA = a.substring(a1 + 1);
                String logB = b.substring(b1 + 1);
                int compareResult = logA.compareTo(logB);
                if (compareResult == 0) {
                    return a.substring(0,a1).compareTo(b.substring(0,b1));
                } else {
                    return compareResult;
                }
            });
        for (String log : logs)
            if (Character.isLetter(log.split(" ")[1].charAt(0)))
                pq.offer(log);
        String[] res = new String[logs.length];
        int idx = 0;
        while (!pq.isEmpty())
            res[idx++] = pq.poll();
        for (String log : logs)
            if (Character.isDigit(log.split(" ")[1].charAt(0)))
                res[idx++] = log;
        return res;
    }
}