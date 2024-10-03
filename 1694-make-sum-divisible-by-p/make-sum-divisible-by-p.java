class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum = sum + nums[i];
            sum = sum % p;
        }        
        if(sum == 0){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = n;
        int curr = 0;
        for(int i = 0 ; i < n ; i++){
            curr = curr + nums[i];
            curr = curr % p;
            int need = (curr - sum + p) % p;
            if(map.containsKey(need)){
                ans = Math.min(ans, i - map.get(need));
            }
            map.put(curr, i);
        }
        return ans == n ? -1 : ans;
    }
}