class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            if(ch[i] == ')') {
                if(stack.isEmpty()) {
                    set.add(i);
                } 
                else{
                    stack.pop();
                }
            }
            if(ch[i] == '(') {
                stack.push(i);
            }
        }
        while(!stack.isEmpty()) {
            set.add(stack.pop());
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++) {
            if(!set.contains(i)) {
                sb.append(ch[i]);
            }
        }
        return new String(sb);
    }
}