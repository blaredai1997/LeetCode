class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        columnNumber -= 1;
        res.append((char)(columnNumber%26+'A'));
        while (columnNumber/26>0) {
            columnNumber /= 26;
            columnNumber -= 1;
            res.insert(0, (char)(columnNumber%26+'A'));
        }
        return res.toString();
    }
}