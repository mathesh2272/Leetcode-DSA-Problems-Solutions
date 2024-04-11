class Solution {
    public String removeKdigits(String num, int k) {
        char[] ch = num.toCharArray();
        int n = ch.length;
        if(n == k){
            return "0";
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            while(!stack.isEmpty() && k > 0 && ch[stack.peek()] > ch[i]){
                stack.pop();
                k--;
            }
            stack.add(i);
        }
        while(k-- > 0){
            stack.pop();
        }
        boolean zero = false;
        StringBuilder sb = new StringBuilder();
        for(int i : stack){
            if(ch[i] == '0' && !zero){
                continue;
            }
            else{
                zero = true;
            }
            sb.append(ch[i]);
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }
}