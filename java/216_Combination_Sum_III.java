class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        recursion(res, temp, k, n, 1);
        return res;
    }
    public void recursion(List<List<Integer>> res, List<Integer> temp, int k, int n, int idx) {
        if (k==0) {
            if (n==0)
                res.add(new ArrayList<>(temp));
            return;
        }
        for (int i=idx; i<=9; i++) {
            if (i>n) return;
            temp.add(i);
            recursion(res, temp, k-1, n-i, i+1);
            temp.remove(temp.size()-1);
        }
    }
}