class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        List<Integer> used = new ArrayList<>(Collections.nCopies(nums.length, 0));
        recursion(res, temp, used, nums);
        return res;
    }
    public void recursion(List<List<Integer>> res, List<Integer> temp, List<Integer> used, int[] nums) {
        if (temp.size()==nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if (used.get(i)==1) continue;
            temp.add(nums[i]);
            used.set(i, 1);
            recursion(res, temp, used, nums);
            temp.remove(temp.size()-1);
            used.set(i, 0);
        }
    }
}