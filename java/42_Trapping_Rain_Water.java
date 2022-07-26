class Solution {
    public int trap(int[] height) {
        // int l = 0, r = 0, black = 0, res = 0;
        // while (r<height.length) {
        //     while (l<height.length && height[l]==0) l++;
        //     if (r==0) r = l+1;
        //     if (l>=height.length || r>=height.length) break;
        //     if (height[r]<height[l])
        //         black += height[r++];
        //     else {
        //         res += Math.min(height[l], height[r])*(r-l-1)-black;
        //         black = 0;
        //         l = r++;
        //     }
        // }
        // int h = l;
        // l = height.length-1;
        // r = height.length-1;
        // black = 0;
        // while (l>=h) {
        //     while (r>=h && height[r]==0) r--;
        //     if (l==height.length-1) l = r-1;
        //     if (r<h || l<h) break;
        //     if (height[l]<height[r])
        //         black += height[l--];
        //     else {
        //         res += Math.min(height[l], height[r])*(r-l-1)-black;
        //         black = 0;
        //         r = l--;
        //     }
        // }
        // return res;
        int l1 = 0, l2 = 0, r1 = height.length-1, r2 = 0, res = 0;
        while (l1<r1) {
            if (height[l1]<height[r1]) {
                if (height[l1]>=l2) l2 = height[l1++];
                else res += l2-height[l1++];
            }
            else {
                if (height[r1]>=r2) r2 = height[r1--];
                else res += r2-height[r1--];
            }
        }
        return res;
    }
}