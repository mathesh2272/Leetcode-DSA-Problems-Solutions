class Solution {
    Long[][] dp;
    long helper(int[] a, int[] b, int i, int j, int n, int m){
        if(i == n){
            return 0;
        }
        if(j == m){
            return Integer.MIN_VALUE;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        long pick = (long)a[i] * b[j] + helper(a, b, i + 1, j + 1, n, m);
        long dont = helper(a, b, i, j + 1, n, m);
        return dp[i][j] = Math.max(pick, dont);
    }
    public long maxScore(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        dp = new Long[n][m];
        return helper(a, b, 0, 0, n, m);
    }
}