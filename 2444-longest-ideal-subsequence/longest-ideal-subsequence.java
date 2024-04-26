class Solution {
    Integer[][] dp;
    public int track(char[] ch, int ind, int n, char prev, int k){
        if(ind == n){
            return 0;
        }
        int prevIndex = prev == '-' ? 26 : prev - 'a';
        if(dp[ind][prevIndex] != null){
            return dp[ind][prevIndex];
        }
        int pick = 0;
        int dont = 0;
        if(Math.abs(prev - ch[ind]) <= k || prev == '-'){
            pick = 1 + track(ch, ind + 1, n, ch[ind], k);
        }
        dont = track(ch, ind + 1, n, prev, k);
        return dp[ind][prevIndex] = Math.max(pick, dont);
    }
    public int longestIdealString(String s, int k) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        dp = new Integer[n][27];
        return track(ch, 0, n, '-', k);
    }
}