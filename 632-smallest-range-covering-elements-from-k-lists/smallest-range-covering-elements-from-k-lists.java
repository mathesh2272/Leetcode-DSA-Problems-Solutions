class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] ans = new int[2];
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> a.get(0) - b.get(0));
        int diff = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(List<Integer> num : nums){
            pq.add(num);
            max = Math.max(max, num.get(0));
        }
        while(true){
            List<Integer> curr = pq.poll();
            int val = curr.remove(0);
            if(diff > max - val){
                ans[0] = val;
                ans[1] = max;
                diff = max - val;
            }
            // System.out.println(Arrays.toString(ans));
            if(curr.isEmpty()){
                break;
            }
            max = Math.max(max, curr.get(0));
            pq.add(curr);
        }
        return ans;
    }
}