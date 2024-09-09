class Solution {
    int mod = 1_000_000_007;
    Long[] dp;
    int[] arr = new int[]{0, 0, 3, 3, 3, 3, 3, 4, 3, 4};
    long helper(char[] ch, int i, int n){
        if(i >= n){
            return 1;
        }
        if(dp[i] != null){
            return dp[i];
        }
        int limit = arr[ch[i] - '0'];
        int j = i + 1;
        long val = 0;
        while(j < n && j < i + limit && ch[i] == ch[j]){
            val = val + helper(ch, j, n) % mod;
            j++;
        }
        val = val + helper(ch, j, n) % mod;
        return dp[i] = val % mod;
    }
    public int countTexts(String pressedKeys) {
        char[] ch = pressedKeys.toCharArray();
        int n = ch.length;
        dp = new Long[n];
        return (int)helper(ch, 0, n);
    }
}