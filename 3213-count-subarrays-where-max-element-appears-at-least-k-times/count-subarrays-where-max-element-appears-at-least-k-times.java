class Solution {
    public long countSubarrays(int[] nums, int k) {
        long ans = 0;
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max, nums[i]);
        }
        int left = 0;
        int right = 0;
        int cnt = 0;
        while(right < n){
            if(max == nums[right]){
                cnt++;
            }
            while(cnt >= k){
                ans += (n - right);
                if(nums[left] == max){
                    cnt--;
                }
                left++;
            }
            right++;
        }
        return ans;
    }
}