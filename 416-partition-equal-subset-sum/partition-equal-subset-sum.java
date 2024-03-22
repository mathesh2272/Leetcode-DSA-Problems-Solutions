class Solution {
    Boolean[][] dp;
    public boolean track(int[] nums, int i, int n, int sum1, int sum2){
        if(i == n){
            if(sum1 == sum2){
                return true;
            }
            return false;
        }
        if(dp[sum2][i] != null){
            return dp[sum2][i];
        }
        return dp[sum2][i] = track(nums, i + 1,  n, sum1 - nums[i], sum2) || track(nums, i + 1, n, sum1, sum2 - nums[i]); // pick || dont
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum += nums[i];
        }
        dp = new Boolean[sum + 1][n];
        return (sum & 1) == 1 ? false : track(nums, 0, n, sum, sum);
    }
}