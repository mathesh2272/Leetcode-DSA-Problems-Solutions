class Solution {
    public String invert(char[] ch){
        int n = ch.length;
        for(int i = 0 ; i < n ; i++){
            ch[i] = ch[i] == '0' ? '1' : '0';
        }
        return new String(ch);
    }
    public StringBuilder reverse(String s){
        return new StringBuilder(s).reverse();
    }
    public char findKthBit(int n, int k) {
        StringBuilder s = new StringBuilder("0");
        for(int i = 1 ; i < n ; i++){
            StringBuilder t = new StringBuilder(s);
            t.append("1");
            t.append(reverse(invert(s.toString().toCharArray())));
            s = t;
        }
        return s.charAt(k-1);
    }
}