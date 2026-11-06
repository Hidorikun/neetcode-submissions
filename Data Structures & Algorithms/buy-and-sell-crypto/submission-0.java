class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0; 
        int[] minLeft = new int[prices.length];
        int[] maxRight = new int[prices.length];

        // compute min left
        minLeft[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minLeft[i] = Math.min(minLeft[i - 1], prices[i]);
        }

        // compute max right
        maxRight[prices.length - 1] = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], prices[i]);
        }

        // compute maxProfit
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, maxRight[i] - minLeft[i]);
        }


        return Math.max(0, maxProfit);
    }
}
