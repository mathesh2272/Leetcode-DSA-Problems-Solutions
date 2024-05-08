class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] ans = new String[n];
        if(n == 1){
            ans[0] = "Gold Medal";
            return ans;
        }
        if(n == 2){
            if(score[0] > score[1]){
                ans[0] = "Gold Medal";
                ans[1] = "Silver Medal";
            }
            else{
                ans[0] = "Silver Medal";
                ans[1] = "Gold Medal";
            }
            return ans;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return b[0] - a[0];
        });
        for(int i = 0 ; i < n ; i++){
            queue.add(new int[]{score[i], i});
        }
        int[] poll = queue.poll();
        ans[poll[1]] = "Gold Medal";
        poll = queue.poll();
        ans[poll[1]] = "Silver Medal";
        poll = queue.poll();
        ans[poll[1]] = "Bronze Medal";
        int val = 4;
        while(!queue.isEmpty()){
            poll = queue.poll();
            ans[poll[1]] = String.valueOf(val);
            val++;
        }
        return ans;
    }
}