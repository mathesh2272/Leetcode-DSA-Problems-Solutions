class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        Map<Character, Integer> map = new HashMap<>();
        int right = 0;
        int left = 0;
        int ans = 0;
        while(right < n){
            map.put(ch[right], map.getOrDefault(ch[right], 0) + 1);
            while(left < right && map.get(ch[right]) > 1){
                map.put(ch[left], map.getOrDefault(ch[left], 0) - 1);
                left++;
            }
            right++;
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}