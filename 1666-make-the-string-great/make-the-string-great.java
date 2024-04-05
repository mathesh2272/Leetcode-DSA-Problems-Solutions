class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        int n = ch.length;
        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty() && Math.abs(stack.peek() - ch[i]) == 32) {
                stack.pop();
            } 
            else {
                stack.push(ch[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}