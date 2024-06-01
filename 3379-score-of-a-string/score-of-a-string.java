class Solution {
    public int scoreOfString(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int ans = 0;
        for(int i = 1 ; i < n ; i++){
            ans += Math.abs(ch[i - 1] - ch[i]);
        }
        return ans;
    }
}