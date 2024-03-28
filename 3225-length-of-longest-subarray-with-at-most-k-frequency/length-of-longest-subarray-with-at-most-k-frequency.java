class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int max  = 0;
        int j = 0;
        boolean tmp;
        boolean flag = true;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            int val = map.get(nums[i]);
            if(val > k){
                flag = false;
                tmp = true;
                while(tmp){
                    map.put(nums[j], map.get(nums[j]) - 1);
                    if(nums[i] == nums[j]){
                        tmp = false;
                    }
                    j++;
                }
            }
            max = Math.max(max, i - j + 1);
        }
        return flag ? n : max;
    }
}