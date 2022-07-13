class Solution {
    // backtracking
    // public List<String> restoreIpAddresses(String s) {
    //     List<String> res = new ArrayList<>();
    //     recursion(res, "", s, 0);
    //     return res;
    // }
    // public void recursion(List<String> res, String temp, String s, int count) {
    //     if (count==4 || s.isEmpty()) {
    //         if (count==4 && s.isEmpty()) res.add(temp.substring(1));
    //         return;
    //     }
    //     for (int i=1; i<=(s.charAt(0)=='0' ? 1 : 3) && i<=s.length(); i++) {
    //         String sub = s.substring(0, i);
    //         if (Integer.parseInt(sub)<=255)
    //             recursion(res, temp+"."+sub, s.substring(i), count+1);
    //     }
    // }
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        for (int i=1; i<=3; i++)
        for (int j=1; j<=3; j++)
        for (int k=1; k<=3; k++)
        for (int l=1; l<=3; l++)
            if (i+j+k+l==s.length()) {
                int I = Integer.parseInt(s.substring(0, i));
                int J = Integer.parseInt(s.substring(i, i+j));
                int K = Integer.parseInt(s.substring(i+j, i+j+k));
                int L = Integer.parseInt(s.substring(i+j+k));
                if (I<=255 && J<=255 && K<=255 && L<=255) {
                    String temp = I+"."+J+"."+K+"."+L;
                    if (temp.length()==s.length()+3)
                        res.add(temp);
                }
            }
        return res;
    }
}