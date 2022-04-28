class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Apply Hash Map
        // Arrays.sort(nums);
        // List<List<Integer>> triplets = new ArrayList<>();
        // Map<Integer,Integer> sets = new HashMap<>();
        // for (int i=0; i<nums.length; i++)
        //     sets.put(nums[i],i);
        // for (int i=0; i<nums.length-2; i++) {
        //     if (i>0 && nums[i]==nums[i-1]) continue;
        //     for (int j=i+1; j<nums.length-1; j++) {
        //         if (j-1!=i && nums[j]==nums[j - 1]) continue;
        //         int n = 0-nums[i]-nums[j];
        //         if (sets.containsKey(n) && sets.get(n)>j) {
        //             triplets.add(Arrays.asList(nums[i],nums[j],n));
        //         }
        //     }
        // }
        // Two Pointers
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i=0; i<nums.length-2; i++) {
            if (i>0 && nums[i]==nums[i-1]) continue;
            int j = i+1, k = nums.length-1, n = 0-nums[i];
            while (j<k) {
                if (nums[j]+nums[k]<n)
                    j++;
                else if (nums[j]+nums[k]>n)
                    k--;
                else {
                    triplets.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while (j<k && nums[j]==nums[j+1])
                        j++;
                    while (j<k && nums[k]==nums[k-1])
                        k--;
                    j++;
                    k--;
                }
            }
        }
        return triplets;
    }
}