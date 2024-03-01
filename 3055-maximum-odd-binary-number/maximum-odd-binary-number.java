class Solution {
    public String maximumOddBinaryNumber(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        if(ch[n - 1] == '0'){
            int tmp = s.lastIndexOf('1');
            ch[n - 1] = '1';
            ch[tmp] = '0';

        }
        int start = 0;
        for(int i = 0 ; i < n - 1 ; i++){
            if(ch[i] == '1'){
                char tmp = ch[i];
                ch[i] = ch[start];
                ch[start] = tmp;
                start++;
            }
        }
        return new String(ch);
    }
}