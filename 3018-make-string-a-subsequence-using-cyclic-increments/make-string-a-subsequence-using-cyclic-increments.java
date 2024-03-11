class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int i = 0;
        int j = 0;
        int n1 = ch1.length;
        int n2 = ch2.length;
        while(i < n1 && j < n2){
            char tmp = (char)(ch1[i] + 1);
            if(tmp > 'z'){
                tmp ='a';
            }
            if(ch1[i] == ch2[j] || tmp == ch2[j]){
                j++;
            }
            i++;
        }
        return j == n2;
    }
}