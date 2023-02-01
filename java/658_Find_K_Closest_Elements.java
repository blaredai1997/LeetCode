class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // int n = arr.length;
        // int[] diffs = new int[n];
        // for (int i = 0; i < n; i++) {
        //     diffs[i] = Math.abs(arr[i] - x);
        // }
        // List<Integer> res = new ArrayList<>();
        // int l = n - 1;
        // while (l - k >= 0) {
        //     if (diffs[l - k] <= diffs[l]) {
        //         l--;
        //     } else {
        //         break;
        //     }
        // }
        // for (int i = l - k + 1; i <= l; i++) {
        //     res.add(arr[i]);
        // }
        // return res;
        int right = binarySearch(arr, x);
        int left = right - 1;
        while (k-- > 0) {
            if (left < 0) {
                right++;
            } else if (right >= arr.length) {
                left--;
            } else if (x - arr[left] <= arr[right] - x) {
                left--;
            } else {
                right++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = left + 1; i < right; i++) {
            res.add(arr[i]);
        }
        return res;
    }
    public int binarySearch(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}