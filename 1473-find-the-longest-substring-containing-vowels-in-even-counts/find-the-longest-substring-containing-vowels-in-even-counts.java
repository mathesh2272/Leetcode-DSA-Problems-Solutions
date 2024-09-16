class Solution {
    public int findTheLongestSubstring(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        Map<Integer, Integer> map = new HashMap<>();
        int mask = 0;
        int ans = 0;
        map.put(0, -1);
        for(int i = 0 ; i < n ; i++){
            if(ch[i] == 'a'){
                mask = mask ^ (1 << 1);
            }
            if(ch[i] == 'e'){
                mask = mask ^ (1 << 2);
            }
            if(ch[i] == 'i'){
                mask = mask ^ (1 << 4);
            }
            if(ch[i] == 'o'){
                mask = mask ^ (1 << 8);
            }
            if(ch[i] == 'u'){
                mask = mask ^ (1 << 16);
            }
            if(map.containsKey(mask)){
                ans = Math.max(ans, i - map.get(mask));
            }
            else{
                map.put(mask, i);
            }
        }
        return ans;
    }
}