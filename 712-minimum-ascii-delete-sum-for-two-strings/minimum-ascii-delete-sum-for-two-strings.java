class Solution {
    Integer[][] dp;
    public int track(char[] ch1, char[] ch2, int i, int j, int n, int m){
        if(i == n || j == m){
            return 0;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        int pick = 0;
        int dont = 0;
        if(ch1[i] == ch2[j]){
            pick += track(ch1, ch2, i + 1, j + 1, n, m) + ch1[i];
        }
        else{
            dont = Math.max(track(ch1, ch2, i + 1, j, n, m), track(ch1, ch2, i, j + 1, n, m));
        }
        return dp[i][j] = Math.max(pick, dont);
    }
    public int minimumDeleteSum(String s1, String s2) {
        int sum1 = 0;
        char[] ch1 = s1.toCharArray();
        int n1 = ch1.length;
        for(int i = 0 ; i < n1; i++){
            sum1 += ch1[i];
        }
        int sum2 = 0;
        char[] ch2 = s2.toCharArray();
        int n2 = ch2.length;
        for(int i = 0 ; i < n2 ; i++){
            sum2 += ch2[i];
        }
        dp = new Integer[n1][n2];
        return sum1 + sum2 - 2 * track(ch1, ch2, 0, 0, n1, n2);
    }
}