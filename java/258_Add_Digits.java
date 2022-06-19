class Solution {
    public int addDigits(int num) {
        if (num==0) return 0;
        // else if (num/10==0 && num%10!=0) return num;
        // return addDigits(num%10 + num/10);
        if (num%9==0) return 9;
        return num%9;
    }
}