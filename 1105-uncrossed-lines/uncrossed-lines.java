class Solution {
    Integer[][] dp;
    public int track(int[] nums1, int[] nums2, int i, int j, int n, int m){
        if(i == n || j == m){
            return 0;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        int pick = 0;
        int dont = 0;
        if(nums1[i] == nums2[j]){
            pick += track(nums1, nums2, i + 1, j + 1, n, m) + 1;
        }
        else{
            dont = Math.max(track(nums1, nums2, i + 1, j, n, m), track(nums1, nums2, i, j + 1, n, m));
        }
        return dp[i][j] = Math.max(dont, pick);
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        dp = new Integer[n1][n2];
        return track(nums1, nums2, 0, 0, n1, n2);
    }
}