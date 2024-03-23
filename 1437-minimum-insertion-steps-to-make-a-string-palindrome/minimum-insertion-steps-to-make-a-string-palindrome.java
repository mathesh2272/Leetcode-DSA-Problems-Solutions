class Solution {
    Integer[][] dp;
    public int track(char[] ch, int i, int j, int n){
        if(i >= j){
            return 0;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        int pick = Integer.MAX_VALUE;
        int dont = 0;
        if(ch[i] == ch[j]){
            pick = track(ch, i + 1, j - 1, n);
        }
        dont += 1 + Math.min(track(ch, i + 1, j, n), track(ch, i, j - 1, n));
        return dp[i][j] = Math.min(pick, dont);
    }
    public int minInsertions(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        dp = new Integer[n][n];
        return track(ch, 0, n - 1, n);
    }
}