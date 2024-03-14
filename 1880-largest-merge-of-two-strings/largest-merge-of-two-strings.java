class Solution {
    public String largestMerge(String word1, String word2) {
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();
        int n = ch1.length;
        int m = ch2.length;
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while(i < n && j < m){
            if(ch1[i] < ch2[j]){
                sb.append(ch2[j++]);
            }
            else if(ch1[i] > ch2[j]){
                sb.append(ch1[i++]);
            }
            else{
                if(word1.substring(i).compareTo(word2.substring(j)) > 0){
                    sb.append(ch1[i++]);
                }
                else{
                    sb.append(ch2[j++]);
                }
            }
        }
        if(i < n){
            sb.append(word1.substring(i));
        }
        if(j < m){
            sb.append(word2.substring(j));
        }
        return new String(sb);
    }
}