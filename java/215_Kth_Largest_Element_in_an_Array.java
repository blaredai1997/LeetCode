class Solution {
    // public int findKthLargest(int[] nums, int k) {
    //     PriorityQueue<Integer> pq = new PriorityQueue<>(k+1);
    //     for (int i=0; i<nums.length; i++) {
    //         pq.add(nums[i]);
    //         if (pq.size()>k)
    //             pq.poll();
    //     }
    //     return pq.poll();
    // }
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k, 0, nums.length-1);
    }
    public int quickSelect(int[] nums, int k, int l, int r) {
        int pivot = l;
        for (int i=l; i<r; i++)
            if (nums[i]<=nums[r])
                swap(nums, pivot++, i);
        swap(nums, pivot, r);
        int count = r - pivot + 1;
        if (count==k) return nums[pivot];
        if (count>k) return quickSelect(nums, k, pivot+1, r);
        return quickSelect(nums, k-count, l, pivot-1);
    }
    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}