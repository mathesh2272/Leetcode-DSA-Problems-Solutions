class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        boolean[][] visited = new boolean[n][m];
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        pq.add(new int[]{0, 0, health});
        while(!pq.isEmpty()){
            int[] poll = pq.poll();
            int i = poll[0];
            int j = poll[1];
            int cur = poll[2];
            if(visited[i][j]){
                continue;
            }
            visited[i][j] = true;
            if(grid.get(i).get(j) == 1){
                cur = cur - 1;
            }
            if(i == n - 1 && j == m - 1 && cur > 0){
                return true;
            }
            for(int[] dir : directions){
                int x = i + dir[0];
                int y = j + dir[1];
                if(x >= 0 && y >= 0 && x < n && y < m){
                    pq.add(new int[]{x, y, cur});
                }
            }
        }
        return false;
    }
}