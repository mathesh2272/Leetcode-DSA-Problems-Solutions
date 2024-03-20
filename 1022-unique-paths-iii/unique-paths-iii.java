class Solution {
    int n;
    int m;
    public int track(int[][] grid, int row, int col, int zero){
        if(row < 0 || col < 0 || row == n || col == m || grid[row][col] == 7 || grid[row][col] == -1){
            return 0;
        }
        if(grid[row][col] == 2 && zero == 0){
            return 1;
        }
        int tmp = grid[row][col];
        grid[row][col] = 7;
        int total = track(grid, row + 1, col, zero - 1) + track(grid, row - 1, col, zero - 1) + track(grid, row, col + 1, zero - 1) + track(grid, row, col - 1, zero - 1);
        grid[row][col] = tmp;
        return total;
    }
    public int uniquePathsIII(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int zero = 0;
        int strow = 0;
        int endcol = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 0){
                    zero++;
                }
                if(grid[i][j] == 1){
                    strow = i;
                    endcol = j;
                }
            }
        }
        return track(grid, strow, endcol, zero + 1);
    }
}