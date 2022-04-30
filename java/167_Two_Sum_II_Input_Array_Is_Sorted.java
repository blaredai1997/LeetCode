class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Binary Search
        // for (int i=0; i<numbers.length; i++) {
        //     int l = i+1, r = numbers.length-1, mid = 0;
        //     int t = target-numbers[i];
        //     while (l<=r) {
        //         mid = (l+r)/2;
        //         if (numbers[mid]==t)
        //             return new int[] {i+1,mid+1};
        //         else if (numbers[mid]<t)
        //             l = mid + 1;
        //         else
        //             r = mid - 1;
        //     }
        // }
        // Two Pointers
        int l = 0, r = numbers.length-1;
        while (l<r) {
            int sum = numbers[l]+numbers[r];
            if (sum==target)
                return new int[] {l+1,r+1};
            else if (sum<target)
                l++;
            else
                r--;
        }
        return null;
    }
}