class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr)
            map.put(a, map.getOrDefault(a, 0)+1);
        Queue<Integer> pq = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            pq.add(entry.getKey());
        int res = 0, count = 0;
        while (count<n/2 && !pq.isEmpty()) {
            count += map.get(pq.poll());
            res++;
        }
        return res;
    }
}