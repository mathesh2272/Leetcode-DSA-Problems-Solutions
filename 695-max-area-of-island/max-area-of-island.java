class Solution {
    int len;
    public int track(int[][] grid, int row, int col, int n, int m){
        if(row < 0 || col < 0 || row >= n || col >= m || grid[row][col] == 0){
            return 0;
        }
        if(grid[row][col] == 1){
            len++;
        }
        grid[row][col] = 0;
        return 1 + track(grid, row + 1, col, n, m) + track(grid, row - 1, col, n, m) + track(grid, row, col + 1, n, m) + track(grid, row, col - 1, n, m);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    len = 0;
                    int val = track(grid, i, j, n , m);
                    if(max < val){
                        max = val;
                    }
                }
            }
        }
        return max;
    }
}