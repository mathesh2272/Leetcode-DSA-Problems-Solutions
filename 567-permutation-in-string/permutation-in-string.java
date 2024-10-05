class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int n = ch1.length;
        int m = ch2.length;
        int[] hash1 = new int[26];
        for(int i = 0 ; i < n ; i++){
            hash1[ch1[i] - 'a']++;
        }
        int left = 0;
        int right = 0;
        while(right < m){
            int key = ch2[right] - 'a';
            if(hash1[key] != 0){
                if(right + n <= m){
                    String s = s2.substring(right, right + n);
                    // System.out.println(s);
                    int[] hash2 = new int[26];
                    for(char c : s.toCharArray()){
                        if(hash1[c - 'a'] == 0){
                            break;
                        }
                        hash2[c - 'a']++;
                    }
                    if(Arrays.equals(hash1, hash2)){
                        return true;
                    }
                }
            }
            right++;
        }
        return false;
    }
}