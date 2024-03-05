class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n  = nums.length;
        long sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum += nums[i];
        }
        long min = Integer.MAX_VALUE;
        long cnt = 0;
        for(int i = 0 ; i < n ; i++){
            long val = nums[i] ^ k;
            long tmp = Math.max(val, nums[i]);
            if(tmp != nums[i]){
                cnt++;
                sum = sum - nums[i] + val;
            }
            min = Math.min(min, Math.abs((nums[i] ^ k) - nums[i]));
        }
        return (cnt & 1) == 1 ? sum - min : sum;
    }
}