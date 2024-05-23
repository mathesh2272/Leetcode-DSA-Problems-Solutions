class Solution {
    Map<Integer, Integer> map;
    public int track(int[] nums, int ind, int n, int k) {
        if(ind == n) {
            return 1;
        }
        int ans = track(nums, ind + 1, n, k);
        if (!map.containsKey(nums[ind] - k) && !map.containsKey(nums[ind] + k)) {
            map.put(nums[ind], map.getOrDefault(nums[ind], 0) + 1);
            ans += track(nums, ind + 1, n, k);
            map.put(nums[ind], map.getOrDefault(nums[ind], 0) - 1);
            if(map.get(nums[ind]) == 0){
                map.remove(nums[ind]);
            }
        }
        return ans;
    }

    public int beautifulSubsets(int[] nums, int k) {
        map = new HashMap<>();
        int n = nums.length;
        return track(nums, 0, n, k) - 1;
    }
}
