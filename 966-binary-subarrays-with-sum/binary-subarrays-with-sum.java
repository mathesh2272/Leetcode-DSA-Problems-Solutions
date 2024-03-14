class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            sum += nums[i];
            ans += sum == goal ? 1 : 0;
            ans += map.getOrDefault(sum - goal, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}