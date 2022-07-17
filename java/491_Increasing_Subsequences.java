class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        helper(res, temp, nums, 0);
        return new ArrayList<>(res);
    }
    public void helper(Set<List<Integer>> res, List<Integer> temp, int[] nums, int idx) {
        if (temp.size()>=2) res.add(new ArrayList<>(temp));
        for (int i=idx; i<nums.length; i++) {
            if (temp.size()==0 || temp.get(temp.size()-1)<=nums[i]) {
                temp.add(nums[i]);
                helper(res, temp, nums, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}