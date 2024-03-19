class Solution {
    int gold = 0;
    public int track(int[][] grid, int n, int m, int row, int col, int sum){
        if(row < 0 || col < 0 || row >= n || col >= m || grid[row][col] == 0){
            return 0;
        }
        sum += grid[row][col];
        gold = Math.max(gold, sum);
        int tmp = grid[row][col];
        grid[row][col] = 0;
        track(grid, n, m, row + 1, col, sum);
        track(grid, n, m, row - 1, col, sum);
        track(grid, n, m, row, col + 1, sum);
        track(grid, n, m, row, col - 1, sum);
        grid[row][col] = tmp;
        return gold;
    }
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] != 0){
                    gold = 0;
                    max = Math.max(max, track(grid, n, m, i, j, 0));
                }
            }
        }
        return max;
    }
}