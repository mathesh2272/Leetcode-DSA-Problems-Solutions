class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        long ans = 0;
        Arrays.sort(nums);
        int n = nums.length;
        int mid = n / 2;
        if(nums[mid] == k){
            return 0;
        }
        else if(nums[mid] > k){
            for(int i = mid ; i >= 0 ; i--){
                if(nums[i] > k){
                    ans += (nums[i] - k);
                }
                else{
                    break;
                }
            }
        }
        else{
            for(int i = mid ; i < n ; i++){
                if(nums[i] < k){
                    ans += (k - nums[i]);
                }
                else{
                    break;
                }
            }
        }
        return ans;
    }
}