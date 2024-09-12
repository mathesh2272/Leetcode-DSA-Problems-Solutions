class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] hash = new int[26];
        int n = words.length;
        char ch[] = allowed.toCharArray();
        for(char c : ch){
            hash[c - 'a']++;
        }
        for(String s : words){
            char[] temp = s.toCharArray();
            for(char c : temp){
                if(hash[c - 'a'] == 0){
                    n--;
                    break;
                }
            }
        }
        return n;
    }
}