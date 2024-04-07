class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();
        char[] ch = s.toCharArray();
        int n = ch.length;
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            if(ch[i] == '('){
                open.push(i);
            }
            else if(ch[i] == '*'){
                star.push(i);
            }
            else{
                if(!open.isEmpty()){
                    open.pop();
                }
                else if(!star.isEmpty()){
                    star.pop();
                }
                else{
                    return false;
                }
            }
        }
        while(!star.isEmpty() && !open.isEmpty()){
            if(star.pop() < open.pop()){
                return false;
            }
        }
        // System.out.println(open);
        // System.out.println(star);
        return open.isEmpty();
    }
}