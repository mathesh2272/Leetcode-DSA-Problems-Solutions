class Solution {
    public String shortestPalindrome(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int midpos = (n / 2) + (n % 2) - 1;
        int max = 0;
        while(midpos >= 0){
            int left = midpos;
            int right = midpos;
            while(left >= 0 && ch[left] == ch[right]){
                left--;
                right++;
            }
            if(left < 0){
                max = right;
                break;
            }
            midpos--;
        }
        midpos = n / 2;
        while(midpos >= 0){
            int left = midpos - 1;
            int right = midpos;
            while(left >= 0 && ch[left] == ch[right]){
                left--;
                right++;
            }
            if(left < 0){
                max = Math.max(max, right);
                break;
            }
            midpos--;
        }
        StringBuffer sb = new StringBuffer(s.substring(max));
        sb.reverse();
        sb.append(s);
        return new String(sb);
    }
}