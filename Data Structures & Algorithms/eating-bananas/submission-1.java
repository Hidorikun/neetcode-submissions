class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, piles[i]);
        }

        int l = 0;
        int r = max + 1;

        while (r - l > 1) {
            int mid = l + (r - l) / 2;

            if (hoursToEat(piles, mid) <= h) { 
                // we can push it 
                r = mid;
            } else {
                // takes too long, search for bigger k
                l = mid;
            }
        }

        return r;
    }

    private long hoursToEat(int[] piles, int k) {
        long hours = 0; 

        for (int i = 0; i < piles.length; i++) {
            hours += (piles[i] / k);
            if (piles[i] % k > 0) {
                hours++;
            }
        }

        return hours;
    }
}
