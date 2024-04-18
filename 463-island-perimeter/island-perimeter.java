class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0; j < m ; j++){
                int count = 0;
                if(grid[i][j] == 1){
                    if(i + 1 < n && grid[i + 1][j] == 1){
                        count++;
                    }
                    if(i - 1 >= 0 && grid[i - 1][j] == 1){
                        count++;
                    }
                    if(j + 1 < m && grid[i][j + 1] == 1){
                        count++;
                    }
                    if(j - 1 >= 0 && grid[i][j - 1] == 1){
                        count++;
                    }
                    perimeter += (4 - count);
                }
            }
        }
        return perimeter;
    }
}