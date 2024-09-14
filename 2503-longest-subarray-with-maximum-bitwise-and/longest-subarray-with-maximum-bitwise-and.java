class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        for(int i = 1 ; i < n ; i++) {
            max = Math.max(max, nums[i]);
        }
        int count = 0;
        int rose = 0;
        for(int i = 0 ; i < n ; i++) {
            if(max == nums[i]) {
                count++;
                rose = Math.max(rose, count);
            } 
            else {
                count = 0;
            }
        }
        return rose;
    }
}