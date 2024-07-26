class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<int[]>[] list = new ArrayList[n];
        for(int i = 0 ; i < n ; i++){
            list[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            int x = edge[0];
            int y = edge[1];
            int z = edge[2];
            list[x].add(new int[]{y, z});
            list[y].add(new int[]{x, z});
        }
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            boolean[] visited = new boolean[n];
            int[] dist = new int[n];
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            pq.add(new int[]{i, 0});
            visited[i] = true;
            dist[i] = 0;
            while(!pq.isEmpty()){
                int[] poll = pq.poll();
                int y = poll[0];
                int w = poll[1];
                if(w > distanceThreshold){
                    continue;
                }
                dist[y] = w;
                visited[y] = true;
                for(int[] arr : list[y]){
                    int ny = arr[0];
                    int nw = arr[1];
                    if(nw + w <= distanceThreshold && !visited[ny]){
                        dist[ny] = nw + w;
                        pq.add(new int[]{ny, nw + w});
                    }
                }
            }
            int cnt = 0;
            for(int j = 0 ; j < n ; j++){
                if(dist[j] != 0 && dist[j] <= distanceThreshold){
                    cnt++;
                }
            }
            if(cnt <= min){
                min = cnt;
                ans = i;
            }
        }
        return ans;
    }
}