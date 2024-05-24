class Solution {
    Map<String, Integer> map;
    public int track(String[] words, int ind, int n, int[] freq, int[] score){
        if(ind == n){
            return 0;
        }
        boolean flag = true;
        int s_score = 0;
        for(char c : words[ind].toCharArray()){
            s_score += score[c - 'a'];
            freq[c - 'a']--;
            if(freq[c - 'a'] < 0){
                flag = false;
            }
        }
        int pick = 0;
        int dont = 0;
        if(flag){
            pick = s_score + track(words, ind + 1, n, freq, score);
        }
        for(char c : words[ind].toCharArray()){
            freq[c - 'a']++;
        }
        dont = track(words, ind + 1, n, freq, score);
        return Math.max(pick, dont);
    }
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[26];
        for(char c : letters){
            freq[c - 'a']++;
        }
        return track(words, 0, words.length, freq, score);
    }
}