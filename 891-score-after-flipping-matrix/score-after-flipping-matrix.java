class Solution {
    public void toggleRow(int[][] grid, int row, int n, int m){
        for(int i = 0 ; i < m ; i++){
            grid[row][i] = grid[row][i] == 0 ? 1 : 0;
        }
    }
    public void toggleCol(int[][] grid, int col, int n, int m){
        for(int i = 0 ; i < n ; i++){
            grid[i][col] = grid[i][col] == 0 ? 1 : 0;
        }
    }
    public int matrixScore(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0 ; i < n ; i++){
            if(grid[i][0] == 0){
                toggleRow(grid, i, n, m);
            }
        }
        for(int j = 1 ; j < m ; j++){
            int one = 0;
            for(int i = 0 ; i < n ; i++){
                one += grid[i][j];
            }
            if(one < n - one){
                toggleCol(grid, j, n, m);
            }
        }
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            int val = 0;
            for(int j = 0 ; j < m ; j++){
                val = (val << 1) | grid[i][j];
            }
            ans += val;
        }
        return ans;
    }
}