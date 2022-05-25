class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        recursion(res, s.toCharArray(), 0);
        return res;
    }
    public void recursion(List<String> res, char[] s, int idx) {
        if (idx==s.length) {
            res.add(new String(s));
            return;
        }
        recursion(res, s, idx+1);
        if (!Character.isLetter(s[idx])) return;
        // A => a   && a =>A
        // 65 => 97 && 97 => 65
        // XOR(0010 0001, 0001 0000)
        s[idx] ^= (1 << 5);
        recursion(res, s, idx+1);
        s[idx] ^= (1 << 5);
    }
}