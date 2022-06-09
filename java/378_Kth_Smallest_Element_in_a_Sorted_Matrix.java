class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // Queue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        // int n = matrix.length;
        // for (int i=0; i<n; i++) {
        //     for (int j=0; j<n; j++) {
        //         if (pq.size()<k) 
        //             pq.add(matrix[i][j]);
        //         else {
        //             if(matrix[i][j]<pq.peek()) {
        //                 pq.poll();
        //                 pq.add(matrix[i][j]);
        //             }
        //         }   
        //     }
        // }       
        // return pq.peek();
        int n = matrix.length;
        int l = matrix[0][0], r = matrix[n-1][n-1];
        while (l<r) {
            int mid = l + (r-l)/2;
            int count = 0, j = n-1;
            for (int i=0; i<n; i++) {
                while (j>=0 && matrix[i][j]>mid) j--;
                count += j+1;
            }
            if (count<k) l = mid+1;
            else r = mid;
        }
        return l;
    }
}