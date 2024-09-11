class Solution {
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        int ans = 0;
        while(xor > 0){
            ans++;
            xor = xor & (xor - 1);
        }
        return ans;
    }
}