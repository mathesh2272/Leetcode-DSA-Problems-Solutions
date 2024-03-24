class Solution {
    public int maximumLengthSubstring(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        while(right < n) {
            char c = ch[right];
            map.put(c, map.getOrDefault(c, 0) + 1);
            while(map.get(c) > 2) {
                char leftChar = ch[left];
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}