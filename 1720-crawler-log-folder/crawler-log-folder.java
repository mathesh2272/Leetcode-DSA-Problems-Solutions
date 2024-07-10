class Solution {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        for(String s : logs){
            if(s.equals("./")){
                continue;
            }
            else if(!s.equals("../")){
                stack.push(s);
            }
            else if(s.equals("../") && !stack.isEmpty()){
                stack.pop();
            }
        }
        return stack.size();
    }
}