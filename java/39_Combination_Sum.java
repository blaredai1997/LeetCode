class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        Arrays.sort(candidates);
        recursion(res, comb, candidates, target, 0);
        return res;
    }
    public void recursion(List<List<Integer>> res, List<Integer> comb, int[] candidates, int target, int idx) {
        if (target==0) {
            res.add(new ArrayList<>(comb));
            return;
        }
        for (int i=idx; i<candidates.length; i++) {
            if (target-candidates[i]<0) return;
            comb.add(candidates[i]);
            recursion(res, comb, candidates, target-candidates[i], i);
            comb.remove(comb.size()-1);
        }
    }
}