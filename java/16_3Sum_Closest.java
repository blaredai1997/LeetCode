class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int dis = Integer.MAX_VALUE;
        for (int i=0; i<len-2; i++) {
            int j = i+1, k = len-1;
            while(j<k) {
                int sum = nums[i]+nums[j]+nums[k]; 
                if (sum==target) return target;
                int d = sum - target;
                if (Math.abs(d)<Math.abs(dis))
                    dis = d;
                if (sum<target)
                    j++;
                else
                    k--;
            }
        }
        return target+dis;
    }
}