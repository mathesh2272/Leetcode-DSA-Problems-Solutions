class Solution {
    Integer[][] dp;
    public int track(int[][] grid, int i, int j, int n, int m){
        if(i == n || j == m){
            return 0;
        }
        if(grid[i][j] == 1){
            return 0;
        }
        if(i == n - 1 && j == m - 1){
            return 1;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        return dp[i][j] = track(grid, i + 1, j, n , m) + track(grid, i, j + 1, n , m);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        dp = new Integer[n][m];
        return track(obstacleGrid, 0, 0, n, m);
    }
}