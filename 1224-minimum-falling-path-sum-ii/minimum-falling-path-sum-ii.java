class Solution {
    static int myMax = Integer.MAX_VALUE;
    Integer[][] dp;
    public int track(int ind, int j, int[][] grid, int n){
        if(ind == n){
            return 0;
        }
        if(dp[ind][j] != null){
            return dp[ind][j];
        }
        int ans = myMax;
        for(int i = 0 ; i < n ; i++){
            if(i != j){
                ans = Math.min(ans, grid[ind][i] + track(ind + 1, i, grid, n));
            }
        }
        return dp[ind][j] = ans;
    }
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        dp = new Integer[n][n];
        int ans = myMax;
        for(int i = 0 ; i < n ; i++){
            ans = Math.min(ans, grid[0][i] + track(1, i, grid, n));
        }
        return ans;
    }
}