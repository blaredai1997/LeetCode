class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i=left; i<=right; i++) {
            // boolean check = true;
            // for (char c : String.valueOf(i).toCharArray()) {
            //     if (c-'0'==0 || i%(c-'0')!=0) {
            //         check = false;
            //         break;
            //     }
            // }
            // if (check) res.add(i);
            int n = 0;
            for (n=i; n>0; n/=10)
                if (n%10==0 || i%(n%10)!=0) break;
            if (n==0) res.add(i);
        }
        return res;
    }
}