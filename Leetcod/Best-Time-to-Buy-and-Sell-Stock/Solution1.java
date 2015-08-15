public class Solution1 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int local = 0;
        int global = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i - 1]) {
                local = local + prices[i] - prices[i - 1];
            }
            else {
                local = Math.max(local + prices[i] - prices[i - 1], 0); 
            }
            global = Math.max(global, local);
        }
        return global;
    }
}
