class Solution {
    Integer[] dp;
    int helper(int[] prices, int prev, int i, int n){
        if(i >= n){
            return 0;
        }
        if(dp[i] != null){
            return dp[i];
        }
        int pick = 0;
        int dont = 0;
        if(prices[prev] < prices[i]){
            pick = pick + (prices[i] - prices[prev]) + helper(prices, i, i + 1, n); 
        }
        dont = helper(prices, i, i + 1, n);
        return dp[i] = Math.max(pick, dont);
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new Integer[n];
        return helper(prices, 0, 0, n);
    }
}