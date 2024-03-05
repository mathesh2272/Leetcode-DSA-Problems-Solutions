class Solution {
    public int minimumLength(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int left = 0;
        int right = n - 1;
        while(left < right){
            if(ch[left] == ch[right]){
                char c = ch[left];
                while(left < right && c == ch[left]){
                    left++;
                }
                while(right >= 0 && c == ch[right]){
                    right--;
                }
            }
            else{
                break;
            }
        }
        return left > right ? 0 : right - left + 1;
    }
}