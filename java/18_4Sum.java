class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    //     Arrays.sort(nums);
    //     List<List<Integer>> quadruplets = new ArrayList<>();
    //     for (int i=0; i<nums.length-3; i++) { 
    //         if (i>0 && nums[i]==nums[i-1]) continue;
    //         for (int j=i+1; j<nums.length-2; j++) {
    //             if (j-1!=i && nums[j]==nums[j-1]) continue;
    //             int l = j+1, r = nums.length-1;
    //             int t = target - nums[i] - nums[j];
    //             while (l<r) {
    //                 int sum = nums[l] + nums[r];
    //                 if (sum<t)
    //                     l++;
    //                 else if (sum>t)
    //                     r--;
    //                 else {
    //                     quadruplets.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
    //                     while (l<r && nums[l]==nums[l+1]) l++;
    //                     while (l<r && nums[r]==nums[r-1]) r--;
    //                     l++;
    //                     r--;
    //                 }
    //             }
    //         }
    //     }
    //     return quadruplets;
    // }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, target, 0, 4);
    }
    // Apply recursion to retrieve values other than applying two pointers
    public List<List<Integer>> nSum(int[] nums, int target, int start, int nloop) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        if (start==nums.length)
            return quadruplets;
        int avg = target/nloop;
        if (nums[start]>avg || nums[nums.length-1]<avg)
            return quadruplets;
        if (nloop==2)
            return twoSum(nums, target, start);
        for (int i=start; i<nums.length; i++) {
            if (i>start && nums[i]==nums[i-1]) continue;
            for (List<Integer> sub : nSum(nums, target-nums[i], i+1, nloop-1)) {
                quadruplets.add(new ArrayList<>(Arrays.asList(nums[i])));
                quadruplets.get(quadruplets.size()-1).addAll(sub);
            }
        }
        return quadruplets;
    }
    // Apply two pointers
    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> pair = new ArrayList<>();
        int l = start, r = nums.length-1;
        while (l<r) {
            int sum = nums[l] + nums[r];
            if (sum<target)
                l++;
            else if (sum>target)
                r--;
            else {
                pair.add(Arrays.asList(nums[l],nums[r]));
                while (l<r && nums[l]==nums[l+1]) l++;
                while (l<r && nums[r]==nums[r-1]) r--;
                l++;
                r--;
            }
        }
        return pair;
    }
}