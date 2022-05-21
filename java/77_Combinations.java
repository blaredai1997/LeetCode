class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        recursion(temp, res, n, k, 0);
        return res;
    }
    public void recursion(List<Integer> temp, List<List<Integer>> res, int n, int k, int idx) {
        if (temp.size()==k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i=idx; i<n; i++){
            temp.add(i+1);
            recursion(temp, res, n, k, i+1);
            temp.remove(temp.size()-1);
        }
    }
}