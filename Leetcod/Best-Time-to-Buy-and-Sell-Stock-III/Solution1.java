public class Solution1 {
    public int maxProfit(int[] prices) {
        return maxProfit(2, prices);
    }
    
    private int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length <= 1) return 0;
        
        if (k >= prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
        
        int[][] local = new int[k][prices.length];
        int[][] global = new int[k][prices.length];
        
        for(int j = 0; j < k; j++) {
            local[j][0] = 0;
            global[j][0] = 0;
        }
        for(int i = 1; i < prices.length; i++) {
            local[0][i] = Math.max(local[0][i - 1] + prices[i] - prices[i - 1], 0);
            global[0][i] = Math.max(global[0][i - 1], local[0][i]);
        }
        
        for(int j = 1; j < k; j++) {
            for(int i = 1; i < prices.length; i++) {
            	if (prices[i] >= prices[i - 1]) {
            		local[j][i] = Math.max(local[j][i - 1] + prices[i] - prices[i - 1], global[j - 1][i - 1] + prices[i] - prices[i - 1]);
            	}
            	else {
            		local[j][i] = Math.max(local[j][i - 1] + prices[i] - prices[i - 1], global[j - 1][i - 1]);
            	}
            	global[j][i] = Math.max(global[j][i - 1], local[j][i]);
            }
        }
        return global[k - 1][prices.length - 1];
    }
}
