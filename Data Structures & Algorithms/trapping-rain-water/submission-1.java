class Solution {
    public int trap(int[] height) {
        int result = 0;
        int maxl = 0; 
        int maxr = 0;
        int l = 0; 
        int r = height.length - 1;

        while (l < r) { 
            maxl = Math.max(maxl, height[l]);
            maxr = Math.max(maxr, height[r]);
            if (maxl <= maxr) {
                result += maxl - height[l];
                l++;
            } else {
                result += maxr - height[r];
                r--;
            }
        }

        return result;
    }
}
