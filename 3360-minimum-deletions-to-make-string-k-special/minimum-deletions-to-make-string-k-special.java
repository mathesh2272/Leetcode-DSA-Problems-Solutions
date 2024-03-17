class Solution {
    public int minimumDeletions(String word, int k) {
        char[] ch = word.toCharArray();
        int n = ch.length;
        int[] hash = new int[26];
        for(int i = 0 ; i < n ; i++){
            hash[ch[i] - 'a']++;
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < 26 ; i++){
            int op = 0;
            for(int j = 0 ; j < 26 ; j++){
                if(hash[i] > hash[j]){
                    op += hash[j];
                }
                else{
                    op += Math.max(0, (hash[j] - hash[i] - k));
                }
            }
            ans = Math.min(ans, op);
        }  
        return ans;
    }
}