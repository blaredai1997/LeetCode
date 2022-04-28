class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Brute Force
        // for (int i = 0; i < nums.length; i++) {
        //    for (int j = i + 1; j < nums.length; j++) {
        //        if (nums[j] == target - nums[i]) {
        //            return new int[] { i, j };
        //        }
        //    }
        // }
        // Apply Hash Map
        HashMap<Integer,Integer> numbers = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++) {
            int n = target-nums[i];
            if (numbers.containsKey(n))
                return new int[] {numbers.get(n), i};
            numbers.put(nums[i],i);
        }
        return null;
    }
}