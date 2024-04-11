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
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(ch[stack.pop()]);
        }
        sb.reverse();
        int ind = 0;
        n = sb.length();
        while(ind < n){
            if(sb.charAt(ind) != '0'){
                break;
            }
            ind++;
        }
        return ind == n ? "0" : sb.toString().substring(ind, n);
    }
}