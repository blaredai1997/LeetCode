class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int res = 0, m = 0, p = 0, g = 0;
        for (int i=0; i<garbage.length; i++) {
            if (garbage[i].indexOf('M')!=-1) m = i;
            if (garbage[i].indexOf('P')!=-1) p = i;
            if (garbage[i].indexOf('G')!=-1) g = i;
            res += garbage[i].length();
        }
        for (int i = 1; i < travel.length; i++)
            travel[i] += travel[i-1];
        if (m>0)
            res += travel[m-1];
        if (p>0)
            res += travel[p-1];
        if (g>0)
            res += travel[g-1];
        return res;
    }
}