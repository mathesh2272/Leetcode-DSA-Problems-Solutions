class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        int max = -1;
        for(int i = 0 ; i < n ; i++){
            if(set.contains(nums[i] * -1)){
                max = Math.max(max, Math.abs(nums[i]));
            }
            set.add(nums[i]);
        }
        return max;
    }
}