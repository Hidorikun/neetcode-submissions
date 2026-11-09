class Solution {
    public int largestRectangleArea(int[] heights) {
        return subSearch(heights, 0, heights.length - 1);
    }

    public int subSearch(int[] heights, int l, int r) {
        // System.out.println("L R " + String.valueOf(l) + " " + String.valueOf(r));
        if (l == r) {
            return heights[l];
        }

        int min = heights[l];

        for (int i = l + 1; i <= r; i++) {
            min = Math.min(min, heights[i]);
        }

        int maxSurface = min * (r - l + 1);
        
        int ll = -1;
        int rr = -1;

        for (int i = l; i <= r + 1; i++) {
            if (i == r + 1 || heights[i] == min) {
                if (ll >= 0 && rr >= 0) {
                    maxSurface = Math.max(maxSurface, subSearch(heights, ll, rr));
                    ll = -1;
                }
            } else {
                if (ll < 0) {
                    ll = i;
                }

                rr = i;
            }
        }
        
        
        return maxSurface;
    }
}
