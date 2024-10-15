class Solution {
    public long minimumSteps(String s) {
        long ans = 0;
        char[] ch = s.toCharArray();
        int n = ch.length;
        long ones = 0;
        for(int i = 0 ; i < n ; i++){
            if(ch[i] == '0'){
                ans = ans + ones;
            }
            else{
                ones++;
            }
        }
        return ans;
    }
}