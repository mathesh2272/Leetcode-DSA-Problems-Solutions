class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int n = ch1.length;
        int right = 0;
        int left = 0;
        int cost = 0;
        while(right < n){
            cost += Math.abs(ch1[right] - ch2[right]);
            if(cost > maxCost){
                cost -= Math.abs(ch1[left] - ch2[left]);
                left++;
            }
            right++;
        }
        return right - left;
    }
}