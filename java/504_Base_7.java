class Solution {
    public String convertToBase7(int num) {
        // if (num<0) return "-"+convertToBase7(-num);
        // if (num<7) return String.valueOf(num);
        // return convertToBase7(num/7) + num%7;
        if (num==0) return "0";
        StringBuilder sb = new StringBuilder();
        boolean neg = num<0;
        num = Math.abs(num);
        while (num!=0) {
            sb.append(num%7);
            num /= 7;
        }
        return neg ? "-"+sb.reverse().toString() : sb.reverse().toString();
    }
}