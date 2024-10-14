class Solution {
    public long maxKelements(int[] nums, int k) {
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            pq.add(nums[i]);
        }
        while(k-- > 0){
            int poll = pq.poll();
            ans = ans + poll;
            pq.add((int)Math.ceil((double)poll / 3));
        }
        return ans;
    }
}