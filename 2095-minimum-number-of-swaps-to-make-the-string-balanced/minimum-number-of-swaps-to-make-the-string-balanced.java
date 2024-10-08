class Solution {
    public int minSwaps(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int open = 0;
        int close = 0;
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            if(ch[i] == '['){
                open++;
            }
            else{
                close++;
            }
            if(open < close){
                open++;
                close--;
                ans++;
            }
        }
        return ans;
    }
}