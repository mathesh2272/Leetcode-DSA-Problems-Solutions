class Solution {
    public int longestValidParentheses(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int open = 0;
        int close = 0;
        int ind = 0;
        int max = 0;
        while(ind < n){
            if(ch[ind] == '('){
                open++;
            }
            else{
                close++;
            }
            if(open == close){
                max = Math.max(max, open + close);
            }
            if(close > open){
                open = close = 0;
            }
            ind++;
        }
        open = close = 0;
        ind = n - 1;
        while(ind >= 0){
            if(ch[ind] == '('){
                open++;
            }
            else{
                close++;
            }
            if(open == close){
                max = Math.max(max, open + close);
            }
            if(close < open){
                open = close = 0;
            }
            ind--;
        }
        return max;
    }
}