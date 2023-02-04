class Solution {
    private List<List<String>> res = new ArrayList<>();
    private List<String> temp = new ArrayList<>();
    private String s;
    public List<List<String>> partition(String s) {
        this.s = s;
        recursion(0);
        return res;
    }
    public void recursion(int idx) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(idx, i)) {
                temp.add(s.substring(idx, i + 1));
                recursion(i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
    public boolean isPalindrome(int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}v