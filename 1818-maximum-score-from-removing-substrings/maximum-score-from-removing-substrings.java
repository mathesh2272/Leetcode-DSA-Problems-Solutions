class Solution {
    public int maximumGain(String s, int x, int y) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        if(x > y){
            for(int i = 0 ; i < n ; i++){
                char c = ch[i];
                if(!stack.isEmpty() && stack.peek() == 'a' && c == 'b'){
                    stack.pop();
                    ans += x;
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
            ch = sb.toString().toCharArray();
            n = ch.length;
            for(int i = 0 ; i < n ; i++){
                char c = ch[i];
                if(!stack.isEmpty() && stack.peek() == 'b' && c == 'a'){
                    stack.pop();
                    ans += y;
                }
                else{
                    stack.push(ch[i]);
                }
            }
            return ans;
        }
        else{
            for(int i = 0 ; i < n ; i++){
                char c = ch[i];
                if(!stack.isEmpty() && stack.peek() == 'b' && c == 'a'){
                    stack.pop();
                    ans += y;
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
            ch = sb.toString().toCharArray();
            n = ch.length;
            for(int i = 0 ; i < n ; i++){
                char c = ch[i];
                if(!stack.isEmpty() && stack.peek() == 'a' && c == 'b'){
                    stack.pop();
                    ans += x;
                }
                else{
                    stack.push(ch[i]);
                }
            }
            return ans;
        }
    }
}