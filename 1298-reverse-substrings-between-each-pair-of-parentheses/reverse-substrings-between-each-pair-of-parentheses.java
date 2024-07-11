class Solution {
    public String reverseParentheses(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            if(ch[i] == ')'){
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.pop();
                int j = 0;
                int len = sb.length();
                while(j < len){
                    stack.push(sb.charAt(j));
                    j++;
                }
            }
            else{
                stack.push(ch[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}