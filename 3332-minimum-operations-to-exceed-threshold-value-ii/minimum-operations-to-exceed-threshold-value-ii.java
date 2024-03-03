class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for(int num : nums){
            queue.offer((long)num);
        }
        int operations = 0;
        while(queue.peek() < k){
            long x = queue.poll();
            long y = queue.poll();
            long result = x * 2 + y;
            queue.offer(result);
            operations++;
        }
        return operations;
    }
}