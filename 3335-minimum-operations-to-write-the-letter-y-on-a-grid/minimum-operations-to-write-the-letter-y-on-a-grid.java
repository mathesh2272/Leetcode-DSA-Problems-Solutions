class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        int min = n * n;
        int half = n / 2;
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                if(i == j){
                    continue;
                }
                int op = 0;
                for(int r = 0 ; r < n ; r++){
                    for(int c = 0 ; c < n ; c++){
                        if(r == c && r <= half){
                            if(grid[r][c] != j){
                                op++;
                            }
                        }
                        else if(r + c == n - 1 && r <= half){
                            if(grid[r][c] != j){
                                op++;
                            }
                        }
                        else if(r >= half && c == half){
                            if(grid[r][c] != j){
                                op++;
                            }
                        }
                        else if(grid[r][c] != i){
                            op++;
                        }
                    }
                }
                min = Math.min(min, op);
            }
        }
        return min;
    }
}