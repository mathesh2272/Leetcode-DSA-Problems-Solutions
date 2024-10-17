class Solution {
    public int getNumber(char[] ch, int n){
        int val = 0;
        for(int i = 0 ; i < n ; i++){
            val = val * 10 + (ch[i] - '0');
        }
        return val;
    }
    public void swap(char[] ch, int i, int j){
        char c = ch[i];
        ch[i] = ch[j];
        ch[j] = c;
    }
    public int maximumSwap(int num) {
        StringBuilder sb = new StringBuilder();
        int val = num;
        while(val > 0){
            sb.append(val % 10);
            val = val / 10;
        }
        char[] ch = sb.reverse().toString().toCharArray();
        int n = ch.length;
        int max = num;
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                if(ch[i] - '0' < ch[j] - '0'){
                    swap(ch, i, j);
                    max = Math.max(max, getNumber(ch, n));
                    swap(ch, i, j);
                }
            }
        }
        return max;
    }
}