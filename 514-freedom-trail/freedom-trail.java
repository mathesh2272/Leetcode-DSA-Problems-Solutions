class Solution {
    Integer[][] dp;
    public int track(char[] ring, char[] key, int x, int y, int n, int m){
        if(y == m){
            return 0;
        }
        if(dp[x][y] != null){
            return dp[x][y];
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            if(ring[i] == key[y]){
                int diff = Math.abs(x - i);
                diff = Math.min(diff, n - diff);
                ans = Math.min(ans, diff + track(ring, key, i, y + 1, n, m));
            }
        }
        return dp[x][y] = ans + 1;
    }
    public int findRotateSteps(String rings, String keys) {
        char[] ring = rings.toCharArray();
        char[] key = keys.toCharArray();
        int n = ring.length;
        int m = key.length;
        dp = new Integer[n][m];
        return track(ring, key, 0, 0, n, m);
    }
}