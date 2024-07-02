class Solution {
    public int minAddToMakeValid(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            if(!stack.isEmpty() && stack.peek() == '(' && ch[i] == ')'){
                stack.pop();
            }
            else{
                stack.push(ch[i]);
            }
        }
        return stack.size();
    }
}