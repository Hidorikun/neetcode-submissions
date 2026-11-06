class Solution {
    public int maxProfit(int[] prices) {
        int minPastPrice = prices[0]; 
        int maxProfit = 0; 

        for (int sellPrice: prices) {
            maxProfit = Math.max(sellPrice - minPastPrice, maxProfit);
            minPastPrice = Math.min(minPastPrice, sellPrice); 
        }

        return maxProfit;
    }
}
