class Solution {
    public long countSubstrings(String s, char c) {
        long count = 0;
        char[] ch = s.toCharArray();
        int n = ch.length;
        for(int i = 0 ; i < n ; i++){
            if(ch[i] == c){
                count++;
            }
        }
        return count * (count + 1) / 2;
    }
}