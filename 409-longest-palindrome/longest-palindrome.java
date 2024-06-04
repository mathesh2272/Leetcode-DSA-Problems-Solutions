class Solution {
    public int longestPalindrome(String s) {
        char[] ch = s.toCharArray();
        int[] hash = new int[52];
        for(char c : ch){
            if(Character.isLowerCase(c)){
                hash[c - 'a']++;
            }
            else{
                hash[c - 'A' + 26]++;
            }
        }
        int len = 0;
        int maxodd = 0;
        int ind = 0;
        for(int i = 0 ; i < 52 ; i++){
            if(hash[i] % 2 == 0){
                len += hash[i];
            }
            else{
                if(maxodd < hash[i]){
                    maxodd = hash[i];
                    ind = i;
                }
            }
        }
        for(int i = 0 ; i < 52 ; i++){
            if(hash[i] % 2 == 1 && i != ind){
                len += (hash[i] - 1);
            }
        }
        return len + maxodd;
    }
}