class Solution {
    int abba(Stack<Character> stack, char[] ch, int n, int x, char a, char b){
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            if(!stack.isEmpty() && stack.peek() == a && ch[i] == b){
                stack.pop();
                ans += x;
            }
            else{
                stack.push(ch[i]);
            }
        }
        return ans;
    }
    int remove(char[] ch, int n, int x, int y, char a, char b){
        Stack<Character> stack = new Stack<>();
        int ans = abba(stack, ch, n, x, a, b);
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        ch = sb.toString().toCharArray();
        n = ch.length;
        return ans + abba(stack, ch, n, y, a, b);
    }
    public int maximumGain(String s, int x, int y) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        return x > y ? remove(ch, n, x, y, 'a', 'b') : remove(ch, n, y, x, 'b', 'a');
    }
}