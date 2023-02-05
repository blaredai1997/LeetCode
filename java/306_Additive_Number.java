class Solution {
    private List<List<Integer>> list = new ArrayList<>();
    private String num;
    private int n;
    public boolean isAdditiveNumber(String num) {
        this.num = num;
        n = num.length();
        return recursion(0);
    }
    public boolean recursion(int idx) {
        int m = list.size();
        if (idx == n) {
            return m >= 3;
        }
        int len = num.charAt(idx) == '0' ? idx + 1 : n;
        List<Integer> temp = new ArrayList<>();
        for (int i = idx; i < len; i++) {
            temp.add(0, num.charAt(i) - '0');
            if (m < 2 || check(list.get(m - 2), list.get(m - 1), temp)) {
                list.add(temp);
                if (recursion(i + 1)) {
                    return true;
                }
                list.remove(list.size() - 1);
            }
        }
        return false;
    }
    public boolean check(List<Integer> a, List<Integer> b, List<Integer> c) {
        List<Integer> res = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < a.size() || i < b.size(); i++) {
            if (i < a.size()) {
                sum += a.get(i);
            }
            if (i < b.size()) {
                sum += b.get(i);
            }
            res.add(sum % 10);
            sum /= 10;
        }
        if (sum > 0) {
            res.add(sum);
        }
        boolean isValid = c.size() == res.size();
        for (int i = 0; i < c.size() && isValid; i++) {
            if (c.get(i) != res.get(i)) {
                isValid = false;
            }
        }
        return isValid;
    }
}