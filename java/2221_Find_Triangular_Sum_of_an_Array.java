class Solution {
    public int triangularSum(int[] nums) {
        // Queue<Integer> q = new LinkedList<>();
        // for (int n : nums) q.add(n);
        // while (q.size()>1) {
        //     int size = q.size();
        //     while (size-->0) {
        //         int num = q.poll();
        //         if (size>0)
        //             q.add((num+q.peek())%10);
        //     }
        // }
        // return q.poll();
        for (int i=nums.length; i>0; i--)
            for (int j=1; j<i; j++)
                nums[j-1] = (nums[j-1]+nums[j])%10;
        return nums[0];
    }
}