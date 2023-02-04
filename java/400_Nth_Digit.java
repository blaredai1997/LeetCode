class Solution {
    public int findNthDigit(int n) {
        int i = 1, count = 9;
        while (n > (long) i * count) {
            n -= i * count;
            i++;
            count *= 10;
        }
        int num = (int)Math.pow(10, i - 1) + (n - 1) / i;
        int digit = (num / (int)(Math.pow(10, i - ((n - 1) % i) - 1))) % 10;
        return digit;
    }
}