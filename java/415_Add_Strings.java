class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1, j = num2.length()-1;
        int pass = 0;
        StringBuilder sb = new StringBuilder();
        while (i>=0 && j>=0) {
            int c = (num1.charAt(i--)-'0')+(num2.charAt(j--)-'0')+pass;
            sb.append(c%10);
            pass = c/10;
        }
        while(i>=0) {
            int c = num1.charAt(i--)-'0'+pass;
            sb.append(c%10);
            pass = c/10;
        }
        while(j>=0) {
            int c = num2.charAt(j--)-'0'+pass;
            sb.append(c%10);
            pass = c/10;
        }
        if (pass!=0) sb.append(pass);
        return sb.reverse().toString();
    }
}