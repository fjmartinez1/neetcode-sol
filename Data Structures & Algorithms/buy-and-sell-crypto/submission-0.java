class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int left = 0;
        int right = 1;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[right] < prices[left]) {
                left = right;
            } else {
                profit = Math.max(profit, prices[right] - prices[left]);
            }

            right++;
        }

        return profit;
    }
}
