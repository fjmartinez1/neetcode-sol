class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 1;
        int maxProfit = 0;

        while (sell < prices.length) {
            int profit = prices[sell] - prices[buy];
            maxProfit = Math.max(profit, maxProfit);

            if (prices[sell] < prices[buy]) {
                buy = sell;
            }

            sell++;
        }

        return maxProfit;
    }
}
