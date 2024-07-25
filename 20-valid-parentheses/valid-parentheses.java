class Solution {
    public boolean isValid(String a) {
        if(a.length()==1) return false;
        Stack<Character> s=new Stack<Character>();
        char arr[]=a.toCharArray();
        for(int i=0;i<a.length();i++){
            switch(arr[i]){
                case '(':
                s.push(')');
                break;
                case '{':
                s.push('}');
                break;
                case '[':
                s.push(']');
                break;
                default:
                if(s.isEmpty()||s.pop()!=arr[i]){
                    return false;
                }
            }
        }
        // for(char ch : a.toCharArray()){
        //     if(ch=='('||ch=='{'||ch=='[')
        //     s.push(ch);
        //     else if(ch==')'){
        //         if(s.empty()||s.pop()!='(')
        //         return false;
        //     }
        //     else if(ch==']'){
        //         if(s.empty()||s.pop()!='[')
        //         return false;
        //     }
        //     else if(ch=='}'){
        //         if(s.empty()||s.pop()!='{')
        //         return false;
        //     }
        // }
        return s.isEmpty();
    }
}