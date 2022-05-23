class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i=0; i<=nums.length; i++)
            recursion(res, temp, nums, 0, i);
        return res;
    }
    public void recursion(List<List<Integer>> res, List<Integer> temp, int[] nums, int idx, int len) {
        if(temp.size()==len) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i=idx; i<nums.length; i++) {
            temp.add(nums[i]);
            recursion(res, temp, nums, i+1, len);
            temp.remove(temp.size()-1);
        }
    }
}