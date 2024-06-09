class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int rose = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0 ; i < n ; i++){
            sum += nums[i];
            int tmp = sum % k;
            tmp = tmp < 0 ? tmp + k : tmp;
            rose += map.getOrDefault(tmp, 0);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        return rose;
    }
}