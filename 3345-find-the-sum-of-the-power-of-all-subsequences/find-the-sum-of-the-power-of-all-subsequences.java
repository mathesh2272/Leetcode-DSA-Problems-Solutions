class Solution {
    int mod = 1_000_000_007;
    Map<Integer, Integer> power;
    Integer[][][] dp;
    public void getPower(int n){
        int pow = 1;
        for(int i = 0 ; i <= n ; i++){
            power.put(i, pow);
            pow *= 2;
            pow %= mod;
        }
    }
    public int track(int[] nums, int n, int k, int ind, int k_level, int sum){
        if(sum == k){
            return power.get(n - k_level);
        }
        if(ind == n || sum > k){
            return 0;
        }
        if(dp[ind][k_level][sum] != null){
            return dp[ind][k_level][sum];
        }
        long ans = track(nums, n, k, ind + 1, k_level + 1, sum + nums[ind]); // pick
        ans += track(nums, n, k, ind + 1, k_level, sum); // dont
        return dp[ind][k_level][sum] = (int)(ans % mod);
    }
    public int sumOfPower(int[] nums, int k) {
        power = new HashMap<>();
        int n = nums.length;
        getPower(n);
        dp = new Integer[n][n][k];
        return track(nums, n, k, 0, 0, 0);
    }
}