class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.put(nums[i], 1);
        }
        int distinct_elements = map.size();
        map = new HashMap<>();
        int left = 0;
        int right = 0;
        int ans = 0;
        while(right < n){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while(map.size() == distinct_elements && left < n){
                ans += n - right;
                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            right++;
        }
        return ans;
    }
}