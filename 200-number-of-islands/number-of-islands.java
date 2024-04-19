class Solution {
    boolean[][] seen;
    char[][] ch;
    int m;
    int n;
    public void dfs(int i, int j) {
        if(i < 0 || j < 0 || i >= m || j >= n || ch[i][j] == '0' || seen[i][j]) {
            return;
        }
        seen[i][j] = true;
        dfs(i + 1, j);
        dfs(i, j + 1);
        dfs(i - 1, j);
        dfs(i, j - 1);
    }
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        seen = new boolean[m][n];
        ch = grid;
        int cnt = 0;
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(grid[i][j] == '1' && !seen[i][j]) {
                    cnt++;
                    dfs(i, j);
                }
            }
        }
        return cnt;
    }
}