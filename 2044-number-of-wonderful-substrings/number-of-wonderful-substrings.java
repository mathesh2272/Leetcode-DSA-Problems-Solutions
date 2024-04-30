class Solution {
    public long wonderfulSubstrings(String word) {
        long[] hash = new long[1024];
        hash[0] = 1;
        long ans = 0;
        int mask = 0;
        for(char c : word.toCharArray()){
            mask ^= 1 << (c - 'a');
            ans += hash[mask];
            for(int i = 0 ; i < 10 ; i++){
                ans += hash[mask ^ (1 << i)]; 
            }
            hash[mask]++;
        }
        return ans;
    }
}