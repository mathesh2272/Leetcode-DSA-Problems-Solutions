class Solution {
    static int max = Integer.MAX_VALUE;
    public int networkDelayTime(int[][] times, int n, int k) {
        if(n == 1 && k == 1){
            return 0;
        }
        if(n == 1){
            return -1;
        }
        List<int[]> graph[] = new ArrayList[n + 1];
        for(int i = 0 ; i <= n ; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] arr : times){
            graph[arr[0]].add(new int[]{arr[1], arr[2]});
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] time = new int[n + 1];
        Arrays.fill(time, max);
        time[k] = 0;
        queue.add(new int[]{k, 0});
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            for(int[] arr : graph[poll[0]]){
                int ver = arr[0];
                int wei = arr[1];
                if(time[ver] > arr[1] + poll[1]){
                    time[ver] = arr[1] + poll[1];
                    queue.add(new int[]{ver, time[ver]});
                }
            }
        }
        int min = -1;
        int maxcount = 0;
        for(int ele : time){
            if(ele == max){
                maxcount++;
                continue;
            }
            if(ele != 0 && min < ele){
                min = ele;
            }
        }
        return maxcount >= 2 ? -1 : min;
    }
}