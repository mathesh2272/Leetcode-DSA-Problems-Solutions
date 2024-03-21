class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int ind = 0;
        while(ind < candidates){
            queue.add(new int[]{costs[ind++], -1});
        }
        ind = Math.max(candidates, n - candidates);
        while(ind < n){
            queue.add(new int[]{costs[ind++], 1});
        }
        long ans = 0;
        int left = candidates;
        int right = n - 1 - candidates;
        for(int i = 0 ; i < k  ; i++){
            int[] poll = queue.poll();
            ans += poll[0];
            if(left <= right){
                if(poll[1] == -1){
                    queue.add(new int[]{costs[left++], -1});
                }
                else{
                    queue.add(new int[]{costs[right--], 1});
                }
            }
        }
        return ans;
    }
}