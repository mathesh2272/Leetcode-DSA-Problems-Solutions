class Solution {
    public int getLucky(String s, int k) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            int val = ch[i] - 'a' + 1;
            sum = sum + val / 10 + val % 10;
        }
        while(k-- > 1){
            int val = 0;
            while(sum > 0){
                val = val + (sum % 10);
                sum = sum / 10;
            }    
            sum = val; 
        }
        return sum;
    }
}