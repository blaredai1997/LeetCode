class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        recursion(res, temp, n, n);
        return res;
    }
    public void recursion(List<String> res, StringBuilder temp, int l, int r) {
        if (l+r==0) {
            res.add(temp.toString());
            return;
        }
        if (r<l) return;
        if (l>0) {
            temp.append("(");
            recursion(res, temp, l-1, ra);
            temp.deleteCharAt(temp.length() - 1);
        }
        if (r>0) {
            temp.append(")");
            recursion(res, temp, l, r-1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}