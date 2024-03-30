class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int right = 0;
        int left = 0;
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        while(right < n){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while(left <= right && map.size() > k){
                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            ans += (right - left + 1);
            right++;
        }
        right = left = 0;
        k = k - 1;
        map = new HashMap<>();
        while(right < n){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while(left <= right && map.size() > k){
                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            ans -= (right - left + 1);
            right++;
        }
        return ans;
    }
}