class Solution {
    Integer[][] dp;
    public int track(char[] ch, int i, int j, int n){
        if(i == n || j == -1){
            return 0;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        int pick = 0;
        int dont = 0;
        if(ch[i] == ch[j]){
            pick += track(ch, i + 1, j - 1, n) + 1;
        }
        else{
            dont = Math.max(track(ch, i + 1, j, n), track(ch, i, j - 1, n));
        }
        return dp[i][j] = Math.max(pick, dont);
    }
    public int longestPalindromeSubseq(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        dp = new Integer[n][n];
        return track(ch, 0, n - 1, n);
    }
}