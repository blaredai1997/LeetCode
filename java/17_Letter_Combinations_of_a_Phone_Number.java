class Solution {
    public List<String> letterCombinations(String digits) {
        // if (digits.length()==0) return new ArrayList<>();
        // String[] letters = new String[]{" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        // List<String> res = new ArrayList<>();
        // res.add("");
        // for (char digit : digits.toCharArray()) {
        //     List<String> temp = new ArrayList<>();
        //     for (String r : res) {
        //         String d = letters[Character.getNumericValue(digit)];
        //         for (int i=0; i<d.length(); i++)
        //             temp.add(r+d.charAt(i));
        //     }
        //     res = temp;
        // }
        if (digits.length()==0) return new ArrayList<>();
        String[] letters = new String[]{" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        char[] temp = new char[digits.length()];
        List<String> res = new ArrayList<>();
        recursion(digits, letters, temp, res, 0);
        return res;
    }
    public void recursion(String digits, String[] letters, char[] temp, List<String> res, int idx){
        if (idx==digits.length()) {
            res.add(new String(temp));
            return;
        }
        String d = letters[Character.getNumericValue(digits.charAt(idx))];
        for (int i=0; i<d.length(); i++) {
            temp[idx] = d.charAt(i);
            recursion(digits, letters, temp, res, idx+1);
        }
    }
}