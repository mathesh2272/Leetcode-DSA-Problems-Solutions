class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int right = 0;
        int left = 0;
        long ans = 0;
        int minind = -1;
        int maxind = -1;
        boolean min = false;
        boolean max = false;
        int n = nums.length;
        while(right < n){
            if(nums[right] < minK || nums[right] > maxK){
                // System.out.println(nums[right]+" "+minK+" "+maxK);
                left = right + 1;  
                min = max = false;
                minind = maxind = -1;
            }
            if(nums[right] == minK){
                min = true;
                minind = right;
            }
            if(nums[right] == maxK){
                max = true;
                maxind = right;
            }
            if(min && max){
                ans += (Math.min(minind, maxind) - left + 1);
            }
            right++;
        }
        return ans;
    }
}