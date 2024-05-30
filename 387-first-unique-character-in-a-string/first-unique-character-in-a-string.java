class Solution {
    public int firstUniqChar(String s) {
        int temp = Integer.MAX_VALUE;
        for(char i = 'a'; i <= 'z' ; i++){
            int val = s.indexOf(i);
            if(val != -1 && val == s.lastIndexOf(i)){
                temp = Math.min(temp, val);
            }
        }
        return Integer.MAX_VALUE == temp ? -1 : temp;
    }
}