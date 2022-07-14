class Solution {
    public String longestCommonPrefix(String[] strs) {
        // String res = "";
        // for (int i=1; i<=strs[0].length(); i++) {
        //     res = strs[0].substring(0, i);
        //     for (String s : strs)
        //         if (i>s.length() || !s.substring(0, i).equals(res))
        //             return res.substring(0, i-1); 
        // }
        // return res;   
        Arrays.sort(strs);
        String first = strs[0], last = strs[strs.length-1];
        int i;
        for (i=0; i<first.length(); i++)
            if (first.charAt(i)!=last.charAt(i))
                break;
        return first.substring(0, i);
    }
}