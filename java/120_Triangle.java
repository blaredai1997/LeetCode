class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
//         // Top down
//         int t = triangle.size();
//         for (int i=1; i<t; i++) {
//             for (int j=0; j<=i; j++) {
//                 int value = triangle.get(i).get(j);
//                 if (j==0)
//                     triangle.get(i).set(j, value+triangle.get(i-1).get(j));
//                 else if (j==i)
//                     triangle.get(i).set(j, value+triangle.get(i-1).get(j-1));
//                 else
                    
//                     triangle.get(i).set(j, value+Math.min(triangle.get(i-1).get(j-1), triangle.get(i-1).get(j)));
//             }
//         }
//         int min = triangle.get(t-1).get(0);
//         for (int i=1; i<triangle.get(t-1).size(); i++)
//             min = Math.min(triangle.get(t-1).get(i), min);
//         return min;
        // Bottom Up
        int len = triangle.size();
        int[] res = new int[len+1];
        for (int i=len-1; i>=0; i--)
            for (int j=0; j<=i; j++)
                res[j] = Math.min(res[j], res[j+1]) + triangle.get(i).get(j);
        return res[0];
    }
}